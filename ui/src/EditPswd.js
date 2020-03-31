import React from "react";
import "./edit.css"
import Nav from "./Nav.js"



export class EditItem extends React.Component {

  constructor(props) {
    super(props);
      
    this.state={
      
      oldPswd:'',
      newPswd:'',
      errors: {
        password: '',
      }


    }
   
    this.handleUpdate=this.handleUpdate.bind(this)
    //this.DateEnabale=this.DateEnabale.bind(this)
    this.handleNewPswdChange=this.handleNewPswdChange.bind(this)
    this.handleOldPswdChange=this.handleOldPswdChange.bind(this)
    this.handleCancel=this.handleCancel.bind(this)

    
  }
  
  handleNewPswdChange=event=>{
    const { name, value } = event.target;
    let errors = this.state.errors;
    errors.password = 
    event.target.value.length < 8
      ? 'Password must be 8 characters long!'
      : '';
    if(errors.password ==  '')
      {
        this.setState({p : true});
      }
      this.setState({errors, [name]: value});
    
  }
  handleOldPswdChange=event=>{
    this.setState({
      oldPswd : event.target.value
    });
    
  }
  handleCancel(){
    //window.location.href="/home";
    window.history.back();
  }
   
  handleUpdate(event) {
    
        event.preventDefault();
        console.log(this.state)
        var body = {
          name:sessionStorage.getItem("name"),
          oldPswd:this.state.oldPswd,
          newPswd:this.state.newPswd
        }
        console.log(body);
        
  

            const url = "http://localhost:9000/editPassword";
            let headers = new Headers();
        
            headers.append('Content-Type','application/json');
            headers.append('Accept','application/json');
        
            headers.append('Access-Control-Allow-origin',url);
            headers.append('Access-Control-Allow-Credentials','true');
        
            headers.append('POST','GET');
        
            fetch(url, {
            headers:headers,
            method: 'POST',
            body: JSON.stringify(body)
            })
            .then(response => {if(response.ok){
                const templateId = 'template_Ne4ypnOa';
                this.sendFeedback(templateId, {message_html: "Your Password has been changed", from_name: "JustNotBooks", email: sessionStorage.getItem("uemail")})
                alert("Password Changed")
                 this.props.history.push("/profile");
          
                
                }
                else {
                  alert("Old Password does not matched")
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
  

    
  
  render() {
    return (
      <div><Nav/>
		<div className="edit">
      
				<form onSubmit={this.displayLogin}>
					<h2>Change Password</h2>

					
                    <div className="oldPswd">
                                    <input
                                        type="password"
                                        placeholder="Old Password"
                                        name="oldPswd"
                                        value={this.state.oldPswd}
                                        onChange={this.handleOldPswdChange} required
                                    />
                            
                    </div>
                    <div className="newPswd">
                                    <input
                                        type="password"
                                        placeholder="New Password"
                                        name="newPswd"
                                        value={this.state.newPswd}
                                        onChange={this.handleNewPswdChange} required
                                    />
                            <span className='error'>{this.state.errors.password}</span>
                    </div>
                      
			
					<input type="submit" value="Update" onClick={this.handleUpdate}/>
                    <input type="submit" value="Cancel" onClick={this.handleCancel}/>
				</form>
			</div>
      </div>
      
    );
  }
}


export default EditItem;