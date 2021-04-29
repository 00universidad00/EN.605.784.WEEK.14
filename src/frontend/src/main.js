import Vue from 'vue'
import Vuex from 'vuex'
import VueRouter from 'vue-router'
import Buefy from 'buefy'


import App from '@/App.vue'
import router from '@/router'
import {library} from '@fortawesome/fontawesome-svg-core'
import {faUserSecret} from '@fortawesome/free-solid-svg-icons'
import {FontAwesomeIcon} from '@fortawesome/vue-fontawesome'
import moment from 'moment';

import 'buefy/dist/buefy.css'
import store from "@/store/index";

library.add(faUserSecret)
Vue.component('font-awesome-icon', FontAwesomeIcon)

Vue.config.productionTip = false

Vue.use(Buefy, {
    defaultDateFormatter: date => {
        return moment(date).format("MM/DD/YYYY");
    }
});

Vue.use(Vuex)
Vue.use(VueRouter)


new Vue({
    router,
    store,
    render: h => h(App),
}).$mount('#app')
