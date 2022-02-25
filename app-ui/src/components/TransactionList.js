import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import { Link } from 'react-router-dom';

class TransactionList extends Component {
	
	state = {
		transactions: []
	}
	
	componentHasMounted() {
		fetch('/transactions')
			.then(response => response.json())
			.then(data => this.setState({transactions: data}));
	}
	
	async remove(id) {
		await fetch('/transactions/${id}', {
			method: 'DELETE',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		}).then(() => {
			let updatedTransactions = [...this.state.transactions].filter(i => i.id !== id);
			this.setState({transactions: updatedTransactions});
		});
	}
	
	constructor(props) {
		super(props);
		this.state = {transactions: []};
		this.remove = this.remove.bind(this);
	}
	
	render() {
		const {transactions, isLoading} = this.state;
		
		if (isLoading) {
			return <p>Loading...</p>;
		}
		
		const transactionList = transactions.map(transaction => {
			return <tr key={transaction.id}>
				<td style={{whiteSpace: 'nowrap'}}>{transaction.name}</td>
				<td>{transaction.email}</td>
				<td>
					<ButtonGroup>
						<Button size="sm" color="primary" tag={Link} to={"/transactions/" + transaction.id}>Edit</Button>
						<Button size="sm" color="danger" onClick={() => this.remove(transaction.id)}>Delete</Button>
					</ButtonGroup>
				</td>
			</tr>
		});
		
		return (
			<div>
				<Container fluid>
					<div className="float-right">
						<Button color="success" tag={Link} to="/transactions/new">Add Transaction</Button>
					</div>
					<h3>Transactions</h3>
					<Table className="mt-4">
						<thead>
						<tr>
							<th width="30%">Name</th>
							<th width="30%">Email</th>
							<th width="40%">Actions</th>
						</tr>
						</thead>
						<tbody>
							{transactionList}
						</tbody>
					</Table>
				</Container>
			</div>
		);
	}
}
export default TransactionList
