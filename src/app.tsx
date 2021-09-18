import { Text, Window, hot, View } from "@nodegui/react-nodegui";
import React from "react";
import { QIcon } from "@nodegui/nodegui";
import { CompOne } from "./components/comp-one";
import { CompTwo } from "./components/comp-two";
import financiallyIcon from "../assets/financially_icon.jpg";

const minSize = { width: 500, height: 500 };
const winIcon = new QIcon(financiallyIcon);
class App extends React.Component {
  render() {
    return (
      <Window
        windowIcon={winIcon}
        windowTitle="Financially"
        minSize={minSize}
        styleSheet={styleSheet}
      >
        <View style={containerStyle}>
          <Text id="welcome-text">Financially - Be In The Money</Text>
          <Text id="step-1">Coming Soon</Text>
          <CompOne />
          <Text id="step-2">Coming Soon</Text>
          <CompTwo />
        </View>
      </Window>
    );
  }
}

const containerStyle = `
  flex: 1; 
`;

const styleSheet = `
  #welcome-text {
    font-size: 24px;
    padding-top: 20px;
    qproperty-alignment: 'AlignHCenter';
    font-family: 'sans-serif';
  }

  #step-1, #step-2 {
    font-size: 18px;
    padding-top: 10px;
    padding-horizontal: 20px;
  }
`;

export default hot(App);
