import Vue from 'vue'
import Router from 'vue-router'

import Entrance from '../view/Entrance.vue'
import Note from '../view/Note.vue'

Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'main',
            component: Entrance
        },
        {
            path: '/note',
            name: 'note',
            component: Note
        }
    ]
});