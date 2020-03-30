import React from "react";
import "./App.css";
import TodoList from "./todo/TodoList";

function App() {
  return (
    <div>
      <h4 className="bg-primary text-white text-center p-2">TodoList</h4>
      <div className="container-fluid">
        <div className="my-1">
          <input className="form-control" />
          <button className="btn btn-primary mt-1"> Add </button>
        </div>
        <TodoList />
      </div>
    </div>
  );
}

export default App;
