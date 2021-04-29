import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";
import VueAxios from "vue-axios";
import notification from './modules/Notification.store'

Vue.use(Vuex);
Vue.use(VueAxios, axios);

Vue.axios.defaults.baseURL = "http://localhost:8080/api/";

export default new Vuex.Store({
    modules: {
        notification
    },
    state: {
        courses: [],
        student: {}
    },
    actions: {
        loadCourses({commit, dispatch}) {
            Vue.axios.get('courses/get/all').then(result => {
                commit('SAVE_COURSES', result.data);
                commit('SAVE_COURSES', result.data);
            }).catch(error => {
                dispatch('notification/showError', 'Failed to load courses.');
                throw new Error(`API ${error}`);
            });
        },
        loadStudent({commit, dispatch}) {
            Vue.axios.get('students/get/juliet1234').then(result => {
                commit('SAVE_STUDENT', result.data);
            }).catch(error => {
                dispatch('notification/showError', 'Failed to load student.');
                throw new Error(`API ${error}`);
            });
        },
        saveStudent({commit, dispatch}, student) {
            Vue.axios.post("students/add", student).then(result => {
                commit('SAVE_STUDENT', result.data);
                dispatch('notification/showSuccess', 'Student profile updated');
            }).catch(error => {
                dispatch('notification/showError', 'Failed to update student profile');
                throw new Error(`API ${error}`);
            });
        },
        registerStudent({commit, dispatch}, params) {
            Vue.axios.post("registrar/add/" + params).then(result => {
                commit('SAVE_STUDENT', result.data);
                dispatch('notification/showSuccess', 'Student added to course');
            }).catch(error => {
                dispatch('notification/showError', 'Failed to add student to course');
                throw new Error(`API ${error}`);
            });
        }
    },
    mutations: {
        SAVE_COURSES(state, courses) {
            state.courses = courses;
        },
        SAVE_STUDENT(state, student) {
            state.student = student;
        },
        SAVE_STUDENT_TO_DB(state, student) {
            // update student in stores
            state.student = student;
            // update student in db
            Vue.axios.post("students/add", state.student).then((response) => {
                console.log(response);
            }, (error) => {
                console.log(error);
            });
        }
    }
})