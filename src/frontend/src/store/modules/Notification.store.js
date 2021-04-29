import {NotificationProgrammatic as message} from "buefy";

const notification = {
    namespaced: true,
    state: {
        type: "empty type",
        isActive: false,
        body: "empty body"
    },
    actions: {
        showSuccess({commit}, body) {
            commit('SET_TYPE', "success");
            commit('SET_IS_ACTIVE', true);
            commit('SET_BODY', body);
            message.open({
                message: body,
                type: 'is-success',
                position: 'is-bottom-right',
                queue: false
            })
        },
        showError({commit}, body) {
            commit('SET_TYPE', "error");
            commit('SET_IS_ACTIVE', true);
            commit('SET_BODY', body);
            message.open({
                message: body,
                type: 'is-danger',
                position: 'is-bottom-right',
                queue: false
            })
        },
        hide({commit}) {
            commit('SET_TYPE', "");
            commit('SET_IS_ACTIVE', false);
            commit('SET_BODY', "");
        }
    },
    mutations: {
        SET_BODY(state, body) {
            state.body = body;
        },
        SET_TYPE(state, type) {
            state.type = type;
        },
        SET_IS_ACTIVE(state, active) {
            state.isActive = active;
        }
    }
}
export default notification;