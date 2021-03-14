import React, { Component } from "react";

class Cards extends React.Component {

constructor(props) {
    super(props);
    this.state = {
      items: [],
      isLoaded: false,
    };
  }

  componentDidMount() {
    fetch('http://localhost:8080/api/warlocks')
      .then(res => res.json())
      .then(result => {
      console.log(result)
        this.setState({
          items: result
        });
      });
  }

  render() {
    const { items } = this.state;
      return (
        <ul>
          {items.map(item => (
            <ul key={item.it} style={{
                    display: "inline-block"
                }}>
                <div style={{
                    background: "rgba(89, 89, 201, 0.3)",
                    borderRadius: "25px",
                    padding: "5px",
                    margin: "5px"

                }}>
                  <img src={item.image} alt="Logo" />
                  <div style={{
                    background: "rgba(89, 89, 201, 0.3)",
                    borderRadius: "15px",
                    padding: "5px",
                    margin: "5px"

                  }}>
                    <h3>{item.name}</h3>
                    <p>
                      {item.typeName}
                    </p>
                    <p>
                      {item.rarityName}
                    </p>
                    <p>
                      {item.cardSetName}
                    </p>
                    <p>
                      {item.className}
                    </p>
                    </div>
                </div>
            </ul>
          ))}
        </ul>
      );
  }
}

export default Cards;