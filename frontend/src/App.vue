<template>
  <div id="app" class="container text-center">
    <img alt="Vue logo" src="./assets/logo.png">
    <modal-login v-if="showLoginForm" v-on:login-successful="onLoginSuccessful"></modal-login>
    <router-view v-on:http-not-authorized="onHttpNotAuthorized"></router-view>
  </div>
</template>

<script>

export default {
  name: 'app',
  data() {
    return {
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
    }
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
