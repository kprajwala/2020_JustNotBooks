import React, { Component } from "react";
//import { Container } from "react-bootstrap";
//import Col from 'react-bootstrap/Col'
//import Row from 'react-bootstrap/Row'
//import UserProfile from "./UserProfile";
import Nav from "./Nav.js"
import "./Buyer.css"
import swal from 'sweetalert'

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
      
class Buyer extends React.Component {

    constructor(props) {
        super(props);
         this.state={
           s:[],
           b:[],
           d:[],
           filter: "",
           data:[],
           st:'buy',
           takenAt:'',
         }
        var today;
        today=new Date();
        var dd = today.getDate(); 
        var mm = today.getMonth() + 1; 
  
        var yyyy = today.getFullYear(); 
        if (dd < 10) { 
            dd = '0' + dd; 
        } 
        if (mm < 10) { 
            mm = '0' + mm; 
        } 
        this.state.takenAt = yyyy+'-'+mm+'-'+dd; 
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
            var note="Thank you for purchasing!!"
            sessionStorage.setItem("notification",note)
            //alert("Thank you for purchasing!!")
            swal("Thanks!","Thank you for purchasing!","success")
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

    handleBorrow(customer,id,fromDate){

      if(this.state.takenAt<fromDate)
      {
        //alert("Cannot Borrow as it is unavailable for now!!");
        swal("Error","Cannot Borrow as it is unavailable for now!!","error")
      }
      else{

        var s=this.state.s;
        var body = {
        customer:customer,
        id:id,
        takenAt:this.state.takenAt
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
            //alert("Thanks for Borrowing!! Return on time is appreciated..")
            swal("Thanks!","Thanks for Borrowing!! Return on time is appreciated..","success")
            window.location.reload(false)
          }
        }) 
      }
      
  
  
    }
    
    renderResultRows(){
      
        let s=this.state.s
        let n
       
        return s.map((item,id) => {
           //console.log(i,typeof(i))
           let img="/pictures/"+item.image
            return (
                <tr id={id} class="tr">
                    
                    <td >{item.itemName}</td>
                    <td><img src={img} width="200px" height="200px" /></td>
                    <td >{item.price}</td>
                    <td >{item.description}</td>
                    <td >{item.owner}</td>
                    <td>{item.category}</td>
                    <td >{item.address}</td>
                    <td >{item.status}</td>
                    <td><button onClick={() => this.handleBuy(sessionStorage.getItem("name"),item.id)} > Buy </button></td>
                     </tr>
            );
        });  
        

    }
    BuyTable(){
      
          return (
            <div class="admin">
            <Nav/>
      

        <button onClick={()=>{this.setState({st:"buy"})}} > Buy </button>
        <button onClick={()=>{this.setState({st:"borrow"})}} > Borrow </button>
        <button onClick={()=>{this.setState({st:"donate"})}} > Donation </button>
              
              <h1>Buy</h1>
                   <div className='Table'>
                   <table id="product" class="w3-table-all">
                      <th>Name</th>
                      <th>Image</th>
                      <th>Price</th>
                      <th>Description</th>
                      <th>Owner</th>
                      <th>Category</th>
                      <th>Address</th>
                      <th>Status</th>
                    <tbody> {this.renderResultRows()} </tbody>
                  </table>
                  </div>
            </div>
            
          );
      

    }
    BorrowTable(){
      
      return (
        <div class="admin">
        <Nav/>
    
    <button onClick={()=>{this.setState({st:"buy"})}} > Buy </button>
    <button onClick={()=>{this.setState({st:"borrow"})}} > Borrow </button>
    <button onClick={()=>{this.setState({st:"donate"})}} > Donation </button>
          
          <h1>Borrow</h1>
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
             <tbody> {this.renderResultBorrow()} </tbody>
            </table>
            
           </div>
        </div>
        
      );
  

        }
        renderResultBorrow(){
              
          let b=this.state.b
          let n
        
          return b.map((item,id) => {
            //console.log(i,typeof(i))
            let img="/pictures/"+item.image
              return (
                  <tr id={id} class="tr">
                      
                      <td >{item.itemName}</td>
                      <td><img src={img} width="200px" height="200px" /></td>
                      <td >{item.price}</td>
                      <td >{item.description}</td>
                      <td >{item.owner}</td>
                      <td >{item.fromDate}</td>
                      <td >{item.toDate}</td>
                      <td>{item.category}</td>
                      <td >{item.address}</td>
                      <td >{item.status}</td>
                      <td><button onClick={() => this.handleBorrow(sessionStorage.getItem("name"),item.id,item.fromDate)} > Borrow </button></td>
                      </tr>
              );
          });  
          

        }

        DonateTable(){
              
          return (
            <div class="admin">
            <Nav/>
         

        <button onClick={()=>{this.setState({st:"buy"})}} > Buy </button>
        <button onClick={()=>{this.setState({st:"borrow"})}} > Borrow </button>
        <button onClick={()=>{this.setState({st:"donate"})}} > Donation </button>
              
              
              <h1>Donation</h1>
              <div className='Table'>
              <table id="product" class="w3-table-all">
                    <th>Name</th>
                    <th>Image</th>
                    <th>Price</th>
                    <th>Description</th>
                    <th>Owner</th>
                    <th>Category</th>
                    <th>Address</th>
                    <th>Status</th>
                <tbody> {this.renderResultDonate()} </tbody>
                </table>
                
              </div>
            </div>
            
          );


        }
      renderResultDonate(){
      
    let d=this.state.d
    let n
   
    return d.map((item,id) => {
       //console.log(i,typeof(i))
       let img="/pictures/"+item.image
        return (
            <tr id={id} class="tr">
                
                <td >{item.itemName}</td>
                <td><img src={img} width="200px" height="200px" /></td>
                <td >{item.price}</td>
                <td >{item.description}</td>
                <td >{item.owner}</td>
                <td>{item.category}</td>
                <td >{item.address}</td>
                <td >{item.status}</td>
                <td><button onClick={() => this.handleBuy(sessionStorage.getItem("name"),item.id)} > Take </button></td>
                 </tr>
        );
    });  
    

}

    buy(){
      const url = "http://localhost:9000/itemsbuy";

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
  borrow(){
    const url = "http://localhost:9000/itemsborrow";

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
        }).then(res=>{this.setState({b:res})
        //console.log(this.state.s) 
    })
    
        
        
                
}
donate(){
  const url = "http://localhost:9000/itemsdonate";

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
      }).then(res=>{this.setState({d:res})
      //console.log(this.state.s) 
  })
  
      
      
              
}
        componentDidMount(){this.buy()
        this.borrow()
      this.donate()}
        handleChange = event => {
          this.setState({ filter: event.target.value });
        };
      
    
        render() {
          
          
           if(this.state.st=="donate")
           {
             return this.DonateTable();
           }
           else if(this.state.st=="borrow"){
             return this.BorrowTable();
           }
           else {
             return this.BuyTable();
           }
            
        }
}

export default Buyer