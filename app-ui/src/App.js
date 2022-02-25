import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import React, { Component } from 'react';
import './App.css';
import AppNavbar from './components/AppNavbar';
import Home from './components/Home';
import TransactionList from './components/TransactionList';
import TransactionEdit from './components/TransactionEdit';

class App extends Component {
	render() {
		return (
			<Router>
				<AppNavbar/>
				<Switch>
					<Route path='/' exact={true} component={Home}/>
					<Route path='/transactions' exact={true} component={TransactionList}/>
					<Route path='/transactions/:id' component={TransactionEdit}/>
				</Switch>
			</Router>
		)
	}
}
export default App;
