import { Redirect } from "react-router-dom";
import React from "react";

class logout extends React.Component{
    constructor(props){
        super(props);
        //console.log("in Logout")
        sessionStorage.clear();
        //UserProfile.clear();
    }
    render(){
        return(
            <Redirect to="/login"/>
        );
    }
}
export default logout