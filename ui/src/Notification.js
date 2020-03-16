import React, { Component } from "react";
import Nav from "./Nav.js"
import {
    Route,
    NavLink,
    HashRouter
  } from "react-router-dom";
  

  class Notification extends React.Component{
    constructor(props){
      super(props);
      this.state={
          s:[],
          l:''
      }
       //sessionStorage.setItem("notification",this.state.notification)
    }
    notifications(){
        const url = "http://localhost:9000/getNotifications";
  
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
            this.state.l=this.state.s.length;
            sessionStorage.setItem("l",this.state.l)
            //console.log(this.state.l)
            
        })     
                    
    }
    handlePay(id){
        var body = {
          customer:sessionStorage.getItem("name"),
          id:id,
      }
        const url = 'http://localhost:9000/pay'
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
              alert("Penalty paid")
              window.location.reload(false)
            }
          }) 
    }
    handleConfirm(id){
        var body = {
          owner:sessionStorage.getItem("name"),
          id:id,
      }
        const url = 'http://localhost:9000/confirm'
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
              alert("Penalty removed")
              window.location.reload(false)
            }
          }) 

    }
    handleButton(cs,id){
        if(cs=="Processed"){
            return(
                <td><button onClick={() => this.handleConfirm(id)} > Payment Done </button></td>
            );
        }
        else{
            return(
                <td><button onClick={() => this.handleConfirm(id)} visibility="hidden"> Payment Done </button></td>
            );
        }
    }
    renderResultNotify(){
      
        let s=this.state.s
        
       
        return s.map((note,id) => {
           //console.log(i,typeof(i))
            if(note.owner==sessionStorage.getItem("name"))
            {
                return (

                    <tr id={id}>
                        
                        <td >{note.ownerNote}</td>
    
                        <td >{note.customer}</td>
                        
                        <td>{note.ownerStatus}</td>
                        <td>{note.customerStatus}</td>
                        <td>{this.handleButton(note.customerStatus,note.id)}</td>
                        
                         </tr>
                );
            }
            
            else{
                return(
                    
                        <h5>No Penalties to be handled</h5>
                    
                )
            }
        });  
      
    }
    renderResultNotification(){
      
        let s=this.state.s
        
       
        return s.map((note,id) => {
           //console.log(i,typeof(i))
            if(note.customer==sessionStorage.getItem("name"))
            {
                return (
                    <tr id={id}>
                        
                        <td >{note.customerNote}</td>
                      
                        <td >{note.owner}</td>
                        <td>{note.customerStatus}</td>
                        <td>{note.ownerStatus}</td>
                        <td><button onClick={() => this.handlePay(note.id)} > Pay </button></td><td></td>
                         </tr>
                );
            }
           else{
               return(
                   <h5>No Penalties</h5>
               )
           }
             
           

        });  
      
    }
   
    componentDidMount(){this.notifications()
        }
  render(){
    return (
      <div>
           <Nav/>
           <div>
               <h1>Notifications</h1>
               <div className="uploadTable">
                   
                   <div>
                       <h1>Confirmation Notifications</h1>
                    <table id="product" class="w3-table-all">
                        <th>Notification</th>
                       
                        <th>Customer</th>
                        <th>Your Status</th>
                        <th>Customer Status</th>
                     <tbody> {this.renderResultNotify()} </tbody>
                    </table>
                    </div>

                    </div>
                    <br></br>
                    <br></br>
                    <br></br>
                    <div className="uploadTable">
                    <div>
                        <h1>Payment Notifications</h1>
                    <table id="product" class="w3-table-all">
                        <th>Notification</th>
                       
                        <th>Owner</th>
                        <th>Your Status</th>
                        <th>Owner Status</th>
                        
                     <tbody> {this.renderResultNotification()} </tbody>
                    </table>
                    </div>
                </div>
                <br></br>
                <br></br>
               
        
                </div>
          
          </div>
      )
  }
   
  }
  
  export default Notification;