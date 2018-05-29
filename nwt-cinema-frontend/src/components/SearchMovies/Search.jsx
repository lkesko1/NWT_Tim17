import React, {Component} from 'react'
import SearchInput, {createFilter} from 'react-search-input'
import {movieEndpoint} from "../../endpoints";
import axios from "axios";
import {List, Button, Icon, Card} from "semantic-ui-react";
import { Link } from "react-router-dom";

export default class Search extends Component {
    constructor (props) {
        super(props)
        this.state = {
            searchTerm: '',
            searchedMovies:{
                "Search" : []

            }
        }
        this.searchUpdated = this.searchUpdated.bind(this)
    }

    myFunction(term){
        axios.get(
            //movieEndpoint + "/get-movies/" + term.target.value)
            "http://www.omdbapi.com/?s="+term.target.value+"&apikey=2d5ee0b5")
            .then(response => {
                const movies = response.data;
                if (movies.Search == null )
                    this.setState({searchedMovies: null});
                    // {this.setState({
                    //
                    //     searchedMovies: {
                    //         "Search": [{"imdbID" : "1",
                    //             "Title" : "NotFound",
                    //             "Year":"Not Found"}]
                    //     }})}
                else
                {this.setState({

                        searchedMovies: movies})}


            })
            .catch(error => {
                this.setState({error: error})
            });

    }

     NotNull() {
         return
             (
             <div class="ui hidden divider">
             <div class = "ui cards">
                 {this.state.searchedMovies.Search.map((movie) =>
                     <div class="card">
                         <div class="content">
                             <List key={movie.imdbID}>

                                 <List.Item>{movie.Title}</List.Item>
                                 <List.Item>{movie.Year}</List.Item>

                             </List>
                         </div>
                         <div class="extra content">
                             <Link to={'/search/'+ movie.imdbID}>
                                 <Button primary floated="right">
                                     View more
                                     <Icon name="right chevron" />
                                 </Button>
                             </Link>
                         </div>
                     </div>)

                  }
                  </div>
                  </div>);

     }

    IsNull() {
        return
            (
            <div class="ui hidden divider">
                <div class = "ui cards">

                        <div class="card">
                            <div class="content">
                                <h1>Not found!</h1>
                            </div>
                        </div>)
                </div>
            </div>);
    }

    Check() {

        if (!this.state.searchedMovies) {
            console.log(this.state.searchedMovies);
            return


            (<div className="ui hidden divider">
                    <div className = "ui cards">

                        <div className="card">
                            <div className="content">
                                <h1>Not found!</h1>
                            </div>
                        </div>
                    </div>
                </div>);
        }
        return

        (<div className="ui hidden divider">
                <div className = "ui cards">
                    {this.state.searchedMovies.Search.map((movie) =>
                        <div className="card">
                            <div className="content">
                                <List key={movie.imdbID}>

                                    <List.Item>{movie.Title}</List.Item>
                                    <List.Item>{movie.Year}</List.Item>

                                </List>
                            </div>
                            <div className="extra content">
                                <Link to={'/search/'+ movie.imdbID}>
                                    <Button primary floated="right">
                                        View more
                                        <Icon name="right chevron" />
                                    </Button>
                                </Link>
                            </div>
                        </div>)

                    }
                </div>
            </div>);
        }


render () {

            //console.log(this.state.searchedMovies.Search);
        return (

            <div>

                <div class="ui icon input">
                    <i class="search icon"></i>
                    <input type="text" onChange={this.myFunction.bind(this)}  placeholder="Type here..." />
                </div>
                {this.Check()}
                {/*<div class="ui hidden divider"></div>*/}
                     {/*<div class = "ui cards">*/}
                         {/*<div class="ui hidden divider"></div>*/}
                     {/*{this.state.searchedMovies.Search.map((movie) =>*/}
                         {/*<div class="card">*/}
                             {/*<div class="content">*/}
                                 {/*<List key={movie.imdbID}>*/}

                                     {/*<List.Item>{movie.Title}</List.Item>*/}
                                    {/*<List.Item>{movie.Year}</List.Item>*/}

                                 {/*</List>*/}
                             {/*</div>*/}
                             {/*<div class="extra content">*/}
                                 {/*<Link to={'/search/'+ movie.imdbID}>*/}
                                     {/*<Button primary floated="right">*/}
                                         {/*View more*/}
                                         {/*<Icon name="right chevron" />*/}
                                     {/*</Button>*/}
                                 {/*</Link>*/}
                             {/*</div>*/}
                         {/*</div>)*/}

                     {/*}*/}
                     {/*</div>*/}
            </div>
        )
    }

    searchUpdated (term) {
        this.myFunction(term);
    }
}