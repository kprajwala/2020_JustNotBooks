import React, { Component } from "react";
import {
    Route,
    NavLink,
    HashRouter
  } from "react-router-dom";
  

const Nav= () => {
    return (
    <div>
          <HashRouter>
          <div>
            <h1>JustNotBooks-Buy.Borrow.Rent</h1>
            <ul className="header">
                  <li><a href="/home">Home</a></li>
                  <li><a href="/buyer">Discovery</a></li>>
                  <li><a href="/seller">Transaction</a></li>
                  <li>< a class="p" href="/logout">Logout</a></li>
                  <li><a class= "p" href="/profile">{sessionStorage.getItem("name")}'s Profile</a></li>
                  
            </ul>
           
  
    </div>
</HashRouter>
        
        </div>
    )
  }
  
  export default Nav;