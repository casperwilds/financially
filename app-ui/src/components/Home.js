import React, { Component } from 'react';
import '../App.css';
import { Container } from 'reactstrap';
import BarChart from "../components/BarChart";

class Home extends Component {
	render() {
		return (
			<div>
				<Container fluid>
					<h1>Home Page</h1>
					<div>
						<BarChart />
					</div>
				</Container>
			</div>
		);
	}
}
export default Home;
