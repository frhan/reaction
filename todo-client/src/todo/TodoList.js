import React, { Component } from "react";
import axios from "axios";
import TodoRow from "./TodoRow";

export default class Todolist extends Component {
  constructor(props) {
    super(props);
    this.state = {
      todoList: []
    };
  }

  componentDidMount() {
    axios.get("http://localhost:8080/api/todos").then(res => {
      const todoList = res.data;
      console.log(todoList);
      this.setState({ todoList });
    });
  }

  todoListRows = () =>
    this.state.todoList.map(item => (
      <TodoRow key={item.id} name={item.name} done={item.done} />
    ));

  render = () => (
    <table className="table table-striped table-bordered">
      <thead>
        <tr>
          <th>Description</th>
          <th>Done</th>
        </tr>
      </thead>
      <tbody>{this.todoListRows()}</tbody>
    </table>
  );
}
