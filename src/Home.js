import React, { Component } from "react";
import { Slide } from 'react-slideshow-image'
import slide1 from './images/prooo3.jpg';
//import slide2 from './ven-2.jpeg';
import "./Home.css"
import slide2 from './images/image1.png'
import "./index.css"
import Nav from "./Nav.js"

const properties = {
  duration: 2000,
  transitionDuration: 500,
  infinite: true,
  indicators: true,
  arrows: true
}


const Home= () => {
  return (
    <div>
    <Nav/>
      <div className="containerSlide">
          <Slide {...properties}>
              <div  className="slideshow">
                  <div><img src={slide2} /></div>
              </div>
              <div className="slideshow" >
                  <div><img src={slide1}/></div>
              </div>
          </Slide>
          <div className="about"><b><h2>About</h2></b>
          <p>JustNotBooks marketplace is a platform for buying, selling, borrowing and donating services and goods such as electronics, items,

          Every academic year, a lot of things (books, notes, drafters, mobile and computer accessories, etc) gets exchanged among students within different colleges and schools.
          Extending the sharing phenomenon to happen across different institutions in the city. 
            </p></div>

      </div>
      </div>
  )
}

export default Home;