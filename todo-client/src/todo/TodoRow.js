import React, { Component } from "react";

export default class TodoRow extends Component {
  constructor(props) {
    super(props);
  }

  render = () => (
    <tr key={this.props.id}>
      <td>{this.props.name}</td>
      <td id={this.props.id}>
        <input type="checkbox" checked={this.props.done} />
      </td>
    </tr>
  );
}
