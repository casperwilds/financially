import { Text, View } from "@nodegui/react-nodegui";
import React from "react";

export function CompOne() {
  return (
    <View style={containerStyle}>
      <Text wordWrap={true}>
        Component One coming soon.
      </Text>
      <Text>
        {`
          <p style="color: rgb(255,72,38);"> 
            <center>
              Space holder  
            </center>
          </p>
          <hr />
        `}
      </Text>
    </View>
  );
}

const containerStyle = `
    margin-horizontal: 20px;
    padding-horizontal: 10px;
`;
