import { Text, View, Button, useEventHandler } from "@nodegui/react-nodegui";
import { QPushButtonSignals } from "@nodegui/nodegui";
import React from "react";
import open from "open";

export function CompTwo() {
  const btnHandler = useEventHandler<QPushButtonSignals>(
    {
      clicked: () => open("https://react.nodegui.org").catch(console.log)
    },
    []
  );
  return (
    <View style={containerStyle}>
      <Text style={textStyle} wordWrap={true}>
        {`
          <ol>
            <li>
                this
            </li>
            <br/>
              <li>
                  is
              </li>
              <br/>
            <li>
               a list
            </li>
          </ol>
        `}
      </Text>
      <Button
        style={btnStyle}
        on={btnHandler}
        text={`Open React NodeGui docs`}
      ></Button>
    </View>
  );
}

const containerStyle = `
  flex: 1;
  justify-content: 'space-around';
`;

const textStyle = `
  padding-right: 20px;
`;

const btnStyle = `
  margin-horizontal: 20px;
  height: 40px;
`;
