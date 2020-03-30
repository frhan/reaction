import React from "react";
import "./App.css";
import TodoList from "./todo/TodoList";

function App() {
  return (
    <div>
      <h4 className="bg-primary text-white text-center p-2">TodoList</h4>
      <div className="container-fluid">
        <TodoList />
      </div>
    </div>
  );
}

export default App;
