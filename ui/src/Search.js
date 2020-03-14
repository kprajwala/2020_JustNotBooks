import React, { Component } from "react";
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
//import UserProfile from "./UserProfile";
import Nav from "./Nav.js"
import "./Buyer.css"
import "./Seller.css"
import Buyer from "./Buyer.js";


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
      
class Search extends React.Component {

    constructor(props) {
        super(props);
         this.state={
           
           s:[],
           takenAt:'',
    
         }
         this.state.takenAt=Date();

    }
    handleBuy(customer,id){

        var s=this.state.s;
        var body = {
          customer:customer,
          id:id,
          takenAt:this.state.takenAt
      }
        const url = 'http://localhost:9000/buy'
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
              const templateId = 'template_Ne4ypnOa';
            this.sendFeedback(templateId, {message_html: "Thank you for purchasing!!", from_name: "JustNotBooks", email: sessionStorage.getItem("uemail")})
              alert("Thank you for Purchasing!!")
              window.location.reload(false)
            }
          }) 
    
    
      }
      sendFeedback (templateId, variables) {
        window.emailjs.send(
          'gmail', templateId,
          variables
          ).then(res => {
            console.log('Email successfully sent!')
          })
          // Handle errors here however you like, or use a React error boundary
          .catch(err => console.error('Oh well, you failed. Here some thoughts on the error that occured:', err))
        }
     
      handleBorrow(customer,id){

        var s=this.state.s;
        var body = {
          customer:customer,
          id:id,
      }
        const url = 'http://localhost:9000/borrow'
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
              const templateId = 'template_Ne4ypnOa';
            this.sendFeedback(templateId, {message_html: "Thanks for Borrowing!! Return on time is appreciated..", from_name: "JustNotBooks", email: sessionStorage.getItem("uemail")})
              alert("Thanks for Borrowing!! Return on time is appreciated..")
              window.location.reload(false)
            }
          }) 
    
    
      }
      
     

     
    renderResultRows(){
      
      let s=this.state.s
      let n
     
      return s.map((item,id) => {
         //console.log(i,typeof(i))
         let img="/pictures/"+item.image
         if(item.category=="buy"){
            return (
                <tr id={id}>
                    
                    <td >{item.itemName}</td>
                    <td><img src={img} width="200px" height="200px" /></td>
                    <td >{item.price}</td>
                    <td >{item.description}</td>
                    <td >{item.owner}</td>
                    <td>{item.fromDate}</td>
                    <td>{item.toDate}</td>
                    <td>{item.category}</td>
                    <td >{item.address}</td>
                    <td >{item.status}</td>
                    <td><button onClick={() => this.handleBuy(sessionStorage.getItem("name"),item.id)} > Buy </button></td>
                     </tr>
            );
         }
         else if(item.category=="borrow"){
            return (
                <tr id={id}>
                    
                    <td >{item.itemName}</td>
                    <td><img src={img} width="200px" height="200px" /></td>
                    <td >{item.price}</td>
                    <td >{item.description}</td>
                    <td >{item.owner}</td>
                    <td>{item.fromDate}</td>
                    <td>{item.toDate}</td>
                    <td>{item.category}</td>
                    <td >{item.address}</td>
                    <td >{item.status}</td>
                    <td><button onClick={() => this.handleBorrow(sessionStorage.getItem("name"),item.id)} > Borrow </button></td>
                     </tr>
            );
         }
         else{
            return (
                <tr id={id}>
                    
                    <td >{item.itemName}</td>
                    <td><img src={img} width="200px" height="200px" /></td>
                    <td >{item.price}</td>
                    <td >{item.description}</td>
                    <td >{item.owner}</td>
                    <td>{item.fromDate}</td>
                    <td>{item.toDate}</td>
                    <td>{item.category}</td>
                    <td >{item.address}</td>
                    <td >{item.status}</td>
                    <td><button onClick={() => this.handleBuy(sessionStorage.getItem("name"),item.id)} > Take </button></td>
                     </tr>
            );
         }
          
      });  
      

  }
  

    items(){
      const url = "http://localhost:9000/search";

      var body = {
        search:sessionStorage.getItem("search"),
        owner:sessionStorage.getItem("name")
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
      
      })
          
          
                  
  }
        componentDidMount(){
          this.items()
          }
    
        render() {
        
      
            return (
              <div>
             
              <div class="admin">
                <Nav/>
              
                    <h1>Items Related to Search</h1>

                        
            
                            <div className='Table'>
                                    <table id="product" class="w3-table-all">
                                            <th>Name</th>
                                            <th>Image</th>
                                            <th>Price</th>
                                            <th>Description</th>
                                            <th>Owner</th>
                                            <th>From</th>
                                            <th>To</th>
                                            <th>Category</th>
                                            <th>Address</th>
                                            <th>Status</th>
                                        <tbody> {this.renderResultRows()} </tbody>
                                  </table>
            
                             </div>
                        
                        </div>
                </div>
            )
        }
}

export default Search