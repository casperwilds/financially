import { createContext, useState } from "react";

const AppContext = createContext({
  tasks: [],
  totalTasks: 0,
  addTask: (task) => {},
  removeTask: (taskId) => {}
});

export function AppContextProvider(props) {
  const [userTasks, setUserTasks] = useState([]);

  function addTaskHandler(task) {
    setUserTasks((prevUserTasks) => {
      return prevUserTasks.concat(task);
    });
  }
  function removeTaskHandler(taskId) {
    setUserTasks((prevUserTasks) => {
      return prevUserTasks.filter((task) => task.id !== taskId);
    });
  }

  const ctx = {
    tasks: userTasks,
    totalTasks: userTasks.length,
    addTask: addTaskHandler,
    removeTask: removeTaskHandler
  };

  return (
    <AppContext.Provider value={ctx}>{props.children}</AppContext.Provider>
  );
}

export default AppContext;
