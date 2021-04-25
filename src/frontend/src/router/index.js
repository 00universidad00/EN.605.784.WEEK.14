import Vue from 'vue'
import Router from 'vue-router'
import Welcome from '@/views/PageWelcome'
import Profile from '@/views/PageProfile'
import Registration from '@/views/PageRegistration'

Vue.use(Router)

export default new Router({
    routes: [
        {
            path: '/',
            name: 'Welcome',
            component: Welcome
        },
        {
            path: '/profile',
            name: 'Profile',
            component: Profile
        },
        {
            path: '/registration',
            name: 'Registration',
            component: Registration
        }
    ]
})