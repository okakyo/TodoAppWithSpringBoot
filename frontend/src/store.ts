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
    todoCards:[],
  },
  mutations: {

  },
  actions: {
    getAllCards:async ()=>{
      await fetch('/api')
          .then((getData)=>{
            state.todoCards=getData;
            console.log('全てのデータ取得');
          })
          .catch(()=>{console.error('データ取得失敗.')})

    },
    getCard:async(data:any)=>{},
    getCardByID:async(id:number)=>{
      await fetch(`api/${id}`)
          .then(()=>{})
          .catch(()=>{})
    },
    postCards:async ()=>{
      await fetch('/api')
    },
    putCard: async (id:number)=>{},
    deleteCard: async (id:number)=>{}
  },
});
