import Vue from 'vue'
import App from './App.vue'
import 'bootstrap'

import router from './router'

import { library } from '@fortawesome/fontawesome-svg-core'
import { faEdit, faTrashAlt, faPlusSquare } from '@fortawesome/free-regular-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faEdit, faTrashAlt, faPlusSquare)

Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
