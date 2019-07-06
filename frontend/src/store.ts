import Vue from 'vue';
import Vuex from 'vuex';


Vue.use(Vuex);


interface State {
  id: number,
  taskTitle: string,
  expiration: Date,
  createdAt: Date,
  done: boolean

}

export default new Vuex.Store({
  state: {

  },
  mutations: {

  },
  actions: {

  },
});
