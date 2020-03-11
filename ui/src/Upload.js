import React from "react";
import "./upload.css"
import Nav from "./Nav.js"

export class Upload extends React.Component {

  constructor(props) {
    super(props);
      
    this.state={
      
      owner:'',
      itemName:'',
      image:'',
      price:'',
      description : '',
      category: '',
      from2 : null,
      to2 :null,

    }
    this.handleItemNameChange=this.handleItemNameChange.bind(this)
    this.handlePriceChange=this.handlePriceChange.bind(this)
    this.handleDescriptionChange=this.handleDescriptionChange.bind(this)
    this.handleAddressChange=this.handleAddressChange.bind(this)
	  this.handleCategoryChange=this.handleCategoryChange.bind(this)
    this.handleFromChange=this.handleFromChange.bind(this)
    this.handleToChange=this.handleToChange.bind(this)
    this.handleSubmit=this.handleSubmit.bind(this)
    this.handleImage=this.handleImage.bind(this)
    //this.DateEnabale=this.DateEnabale.bind(this)
    this.state.owner = sessionStorage.getItem("name");
    
  }
  
  DateEnable(event){
    if (document.getElementById("borrow").checked) {
      document.getElementById("from2").style.visibility = 'visible';
      document.getElementById("to2").style.visibility = 'visible';
  }
  else {
    document.getElementById('from2').style.visibility = 'hidden';
    document.getElementById('to2').style.visibility = 'hidden';
  }
  
  }
  handleItemNameChange=event=>{
    this.setState({
      itemName : event.target.value      
    });
    
  }
  handleImage=event=>{
    this.setState({
      image:event.target.value
    });
  }
  handlePriceChange=event=>{
    this.setState({
      price : event.target.value
    });
    
  }
  handleDescriptionChange=event=>{
    this.setState({
      description : event.target.value
    });
    
  }
  handleAddressChange=event=>{
    this.setState({
      address : event.target.value
    });
    
  }

  handleCategoryChange=event=>{
    this.setState({
      category : event.target.value
    });
    
  }
  handleFromChange=event=>{
    this.setState({
      from2 : event.target.value
    });
    
  }
  handleToChange=event=>{
    this.setState({
      to2 : event.target.value
    });
    
  }

  handleSubmit(event) {
    
    event.preventDefault();
    console.log(this.state)
     var body = {
        owner:this.state.owner,
        itemName:this.state.itemName,
        price:this.state.price,
        image:this.state.image,
        description : this.state.description,
        address:this.state.address,
        category: this.state.category,
        from2: this.state.from2,
        to2 : this.state.to2,
    }

    console.log(body);
        if(this.state.itemName==""){
  
        }
    else if(this.state.price==""){
        alert('Please enter the price')
    }
    else if(this.state.description==""){
    alert('Please enter the description')
    }
    
    else{
    

  const url = "http://localhost:9000/item";
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
    .then(response => response.json())
    .then(contents => {console.log(contents);
    sessionStorage.setItem("itemName",this.state.itemName);
    sessionStorage.setItem("price",this.state.price);
    sessionStorage.setItem("description",this.state.description);
    sessionStorage.setItem("address",this.state.address);
    sessionStorage.setItem("category",this.state.category);
    sessionStorage.setItem("from2",this.state.from2);
    sessionStorage.setItem("to2",this.state.to2);
	
                      
 })
 .catch(()=> console.log("can't access " + url + " response. "))


 alert('Item uploaded');
 
  }
}

  

  render() {
    let today = new Date().toISOString().substr(0, 10);
    return (
      <div><Nav/>
		<div className="upload" >
      
				<form>
					<h5><div align = "center"><h3>Upload</h3></div>
						Item Name:<br></br><input
							type="text"
							placeholder="Item Name"
							name="itemName"
							value={this.state.itemName}
							onChange={this.handleItemNameChange} required
						/><br></br>
            Image:<br></br><input 
              type="file" 
              name="image" 
              id="image" 
              value={this.state.image}
              onChange={this.handleImage} required
            /><br></br>
                        Price:
                        <br></br><input
                            type="text"
                            placeholder="Price"
                            name="price"
                            value={this.state.price}
                            onChange={this.handlePriceChange} required
                        />
                        <br></br>
                        Description:<br></br><textarea
                            rows="inline"
                            columns="inline"
                            type="text"
                            name="description"
                            value={this.state.description}
                            onChange={this.handleDescriptionChange} required
                        />
                        <br></br>
                        <br></br>
                        Address:<br></br><textarea
                            rows="inline"
                            columns="inline"
                            type="text"
                            name="address"
                            value={this.state.address}
                            onChange={this.handleAddressChange} required
                        />
                        <br></br>
                        <br></br>
                    <div className="category">
                        <label>
                            <input type="radio" id="buy" name="category" value="buy" onClick= {this.DateEnable.bind(this)} onChange={this.handleCategoryChange}/>Buy
                        </label>
                        <label>
                            <input type="radio" id="borrow" name="category" value="borrow" onClick= {this.DateEnable.bind(this)} onChange={this.handleCategoryChange}/>Borrow
                        </label>
                        <label>
                            <input type="radio" id="donate" name="category" value="donate" onClick= {this.DateEnable.bind(this)} onChange={this.handleCategoryChange}/>Donate
                        </label>
                    </div>
                    <br></br>
                    From:<input
                            type="date"
                            placeholder="From Date"
                            name="from2"
                            id="from2"
                            min={today}
                            value={this.state.from2}
                            visibility="hidden"
                            onChange={this.handleFromChange} required
                            
                        />
                    <p>  </p>To:<input
                            type="date"
                            placeholder="To Date"
                            name="to2"
                            id="to2"
                            min={this.state.from2}
                            value={this.state.to2}
                            visibility="hidden"
                            onChange={this.handleToChange} required
                           
                        />


		

					<div align="center" ><input type="submit" value="Submit" onClick={this.handleSubmit}/></div></h5>
				</form>

			</div>
      </div>
    );
  }
}


export default Upload;