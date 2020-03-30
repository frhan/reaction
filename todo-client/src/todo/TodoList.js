import React, { Component } from "react";
import axios from "axios";
import TodoRow from "./TodoRow";
import TodoCreator from "./TodoCreator";

export default class TodoList extends Component {
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

  toggleTodo = todo => {};

  todoChangeCallback = (type, todo) => {};

  todoListRows = () =>
    this.state.todoList.map(item => (
      <TodoRow key={item.id} name={item.name} done={item.done} />
    ));

  createNew = todo => {
    console.log("create new todo ", todo);
    axios.post("http://localhost:8080/api/todos/new", todo).then(res => {
      this.state.todoList.push(todo);
      this.setState(this.state.todoList);
    });
  };

  render = () => (
    <div>
      <TodoCreator callback={this.createNew} />
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Description</th>
            <th>Done</th>
          </tr>
        </thead>
        <tbody>{this.todoListRows()}</tbody>
      </table>
    </div>
  );
}
