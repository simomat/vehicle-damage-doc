<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <Documentation/>
  </div>
</template>

<script>
import Documentation from './components/Documentation.vue'

export default {
  name: 'app',
  components: {
    Documentation
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
