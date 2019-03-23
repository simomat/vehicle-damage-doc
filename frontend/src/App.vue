<template>
  <div id="app" class="container text-center">
    <img alt="Vue logo" src="./assets/logo.png">
    <modal-login v-if="showLoginForm" v-on:login-successful="onLoginSuccessful"></modal-login>
    <div class="alert alert-danger" v-if="error">{{ error }}</div>
    <router-view
            v-on:http-not-authorized="onHttpNotAuthorized"
            v-on:printable-error="onPrintableError"></router-view>
  </div>
</template>

<script>

import {tryRestoreAuthToken} from "./http-comons";

export default {
  name: 'app',
  data() {
    return {
      error: '',
      showLoginForm: false,
      loginSuccessfulHandler: null
    }
  },
  methods: {
    onLoginSuccessful: function () {
      this.showLoginForm = false
      if (this.loginSuccessfulHandler) {
        this.loginSuccessfulHandler()
      }
    },
    onHttpNotAuthorized: function (handler) {

      this.loginSuccessfulHandler = handler
      this.showLoginForm = true
    },
    onPrintableError: function (message) {
      this.error = message
    }
  },
  beforeCreate() {
      tryRestoreAuthToken()
  },
  components: {
  }
}
</script>

<style>
@import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
