import React, { Component } from "react";
import { Bar } from "react-chartjs-2";
import '../App.css';

class BarChart extends Component {
	render() {
		return (
			<div>
				<h3>Hello world</h3>
				<div>
					<Bar
						data={{
							labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
						}}
						height={300}
						width={400}
						options={{
							maintainAspectRatio: false,
						}}
					/>
				</div>
			</div>
		);
	}
}
export default BarChart;
