import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import thunk from "redux-thunk";
import reducers from "./state"
import { createStore, applyMiddleware, compose } from "redux";
import { Provider } from "react-redux";

let store = createStore(
  reducers, 
  compose(applyMiddleware(thunk))
);

ReactDOM.render(
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById("root")
);