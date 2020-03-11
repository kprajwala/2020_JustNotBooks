import React, { Component } from "react";
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
//import UserProfile from "./UserProfile";
import Nav from "./Nav.js"
import "./Buyer.css"
import "./Seller.css"
import EditItem from "./EditItem"

const admin = {
    width: '100%',
    height: '100%',
    backgroundRepeat: 'no-repeat',
    backgroundSize: '100% 100%', 
}

const table = {
    top:'20%',
    left:'40%'
}
      
class Seller extends React.Component {

    constructor(props) {
        super(props);
         this.state={
           s:[],
           t:[],
           filter: "",
    data: [
      {
        fname: "Jayne",
        lname: "Washington",
        email: "jaynewashington@exposa.com",
        gender: "female"
      },
      {
        fname: "Peterson",
        lname: "Dalton",
        email: "petersondalton@exposa.com",
        gender: "male"
      },
      {
        fname: "Velazquez",
        lname: "Calderon",
        email: "velazquezcalderon@exposa.com",
        gender: "male"
      },
      {
        fname: "Norman",
        lname: "Reed",
        email: "normanreed@exposa.com",
        gender: "male"
      }
    ]
  }

    
         
       }
       handleChange = event => {
        this.setState({ filter: event.target.value });
      };
    
       handleDelete(owner,id){

        var s=this.state.s;
        var body = {
          owner:owner,
          id:id,
      }
        const url = 'http://localhost:9000/delete'
          let headers = new Headers();
    
          headers.append('Content-Type', 'application/json');
          headers.append('Accept', 'application/json');
    
          headers.append('Access-Control-Allow-origin', url);
          headers.append('Access-Control-Allow-Credentials', 'true');
    
          headers.append('GET','POST');
    
          fetch(url,{
              headers: headers,
              method: 'POST',
              body:JSON.stringify(body)
          })
          .then(response => {
            if(response.ok){
              //alert(UserProfile.getName())
              window.location.reload(false)
            }
          }) 
    
    
      }
    
    renderResultRows(){
      
        let s=this.state.s
        let n
        sessionStorage.setItem("price",this.state.s.price);
        sessionStorage.setItem("address",this.state.s.address);
        sessionStorage.setItem("description",this.state.s.description);
        sessionStorage.setItem("category",this.state.s.category);
        sessionStorage.setItem("id",this.state.s.id);
       
        return s.map((item,id) => {
           //console.log(i,typeof(i))
           if(item.customer==null){
            return (
                <tr id={id}>
                    
                    <td >{item.itemName}</td>
                    <td >{item.price}</td>
                    <td >{item.description}</td>
                    <td >{item.customer}</td>
                    <td>{item.category}</td>
                    <td >{item.address}</td>
                    <td >{item.status}</td>
                    <td><button onClick={() => this.handleDelete(sessionStorage.getItem("name"),item.id)} > Delete </button></td>
                    <td><button onClick={() => window.location.href="./editItem/"+item.id} > Edit </button></td>
                     </tr>
            );
    
            }
            else{
              return (
                <tr id={id}>
                    
                    <td >{item.itemName}</td>
                    <td >{item.price}</td>
                    <td >{item.description}</td>
                    <td >{item.customer}</td>
                    <td>{item.category}</td>
                    <td >{item.address}</td>
                    <td >{item.status}</td>
                    <td><button onClick={() => this.handleDelete(sessionStorage.getItem("name"),item.id)} > Delete </button></td><td></td>
                     </tr>
            );
            }
        });  
      
    }
    renderResultTaken(){
      
      let t=this.state.t
      let n
     
      return t.map((item,id) => {
         //console.log(i,typeof(i))
          return (
              <tr id={id}>
                  
                  <td >{item.itemName}</td>
                  <td >{item.price}</td>
                  <td >{item.description}</td>
                  <td >{item.owner}</td>
                  <td>{item.category}</td>
                  <td >{item.address}</td>
                  <td >{item.status}</td>
                   </tr>
          );
      });  
      

  }
  taken(){
    const url = "http://localhost:9000/itemtaken";

    var body = {
      customer:sessionStorage.getItem("name"),
  }
    let headers = new Headers();
    headers.append('Content-Type','application/json');
    headers.append('Accept','application/json');

    headers.append('Access-Control-Allow-origin',url);
    headers.append('Access-Control-Allow-Credentials','true');

    headers.append('POST','GET');
    
     fetch(url,{
        headers:headers,
        method: 'POST',
        body:JSON.stringify(body)
        })
        .then(response=>{                
            return response.json()
        }).then(res=>{this.setState({t:res})
        //console.log(this.state.s) 
    })
        
        
                
}

    items(){
      const url = "http://localhost:9000/itemupload";

      var body = {
        owner:sessionStorage.getItem("name"),
    }
      let headers = new Headers();
      headers.append('Content-Type','application/json');
      headers.append('Accept','application/json');

      headers.append('Access-Control-Allow-origin',url);
      headers.append('Access-Control-Allow-Credentials','true');

      headers.append('POST','GET');
      
       fetch(url,{
          headers:headers,
          method: 'POST',
          body:JSON.stringify(body)
          })
          .then(response=>{                
              return response.json()
          }).then(res=>{this.setState({s:res})
          //console.log(this.state.s) 
      })
          
          
                  
  }
        componentDidMount(){
          this.items()
          this.taken()}
    
        render() {
          const { filter, data } = this.state;
          //const lowercasedFilter = filter.toLowerCase();
          const filteredData = data.filter(item => {
            return Object.keys(item).some(key =>
              item[key].includes(filter)
            );
          });
      
            return (
              <div>
             
              <div class="admin">
                <Nav/>
              <form className="search">
              <input
                placeholder="Search for..."
                ref={input => this.search = input}
                onChange={this.handleChange}
              />
            </form>
            <h1>Items Uploaded</h1>
            <div className="uploadTable">
                   
                   <div>
                    <table id="product" class="w3-table-all">
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Customer</th>
                        <th>Category</th>
                        <th>Address</th>
                        <th>Status</th>
                     <tbody> {this.renderResultRows()} </tbody>
                    </table>
                    </div>
                </div>
                <br></br>
                <br></br>
                <h1>Items Taken</h1>
                  <div className="uploadTable">
                    
                    <table id="product" class="w3-table-all">
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Owner</th>
                        <th>Category</th>
                        <th>Address</th>
                        <th>Status</th>
                     <tbody> {this.renderResultTaken()} </tbody>
                    </table>
                    </div>
        
                </div>
                </div>
            )
        }
}

export default Seller