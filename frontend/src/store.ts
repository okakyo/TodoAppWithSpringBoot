import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
import todocard from "@/components/todocard.vue";

Vue.use(Vuex);

export interface CardType{
  id: number,
  title: string,
  expiration: Date,
  done: boolean,
  createdAt: Date,
  updateAt:Date,
}

interface State {
  card:{}
  cards: CardType[],
  postCards:CardType[],
  title: string,
  expiration: Date |null ,
}



function setDatetime(date:Date){
  return date.getFullYear()+"年"+date.getMonth()+"月"+1+date.getDay()+"日"
}

const http=axios.create({
    baseURL: "http://localhost:5050",
    headers: {
        "Content-Type": "application/json",
        },
    }

)

const state:State={
  card: {},
  cards: [],
  postCards:[],
}

const mutations={
  getTodo(state:State, newCards:[]) {
    state.cards = newCards;
  },
  getTodoById(state:State,setData:CardType){
    state.card=setData;


  },
  postTodo(state:State,payload:any){
    state.postCards=payload.cards
  },
  putTodo(state:State,payload:any){
  },
  deleteTodo(){},
}

const getters={
  getData:(state:State)=>{
    return state.cards;
  },
  getCard:(state:State)=>{
    return state.card;
  },
}

const actions={
  async getTodo(context:any){
    let newCards:[]=[];
    await http.get('/api').then(res=>{

       newCards=res.data;
      }).catch(e=>{
       console.error(e);
       console.log('データ取得に失敗しました。');
    });
      context.commit('getTodo',newCards)
  },
  async getTodoById(context:any,id:number) {
    let setData:any;

    await http.get(`/api/${id}`).then(res=>{
      setData=res.data;
    }).catch(e=>{
      console.error(e);
    });

    context.commit('getTodoById',setData);
  },

  async postTodo(context:any,card:CardType){
    await http.post('/api',card).then(res=>{
      state.postCards=res.data;
      state.cards.push(res.data);
    }).catch(e=>{
      console.error(e);
    console.log('データ送信時にエラーが発生しました。');
    });
    context.commit('getTodo',state.cards);
  },
  async putTodo(context:any,id:Number,card:CardType){
    await http.put(`/api/${id}`,card).then(res=>{
      console.log(`ID：${id}の情報を更新しました。`)
    }).catch(e=>{
      console.error(e);
    }
    )
    context.commit('putTodo');

  },
  async deleteTodo(context:any,id:Number){
    await http.delete(`/api/${id}`).then(res=>{
      console.log('データを削除します。');
      return res;

    }).catch(e=>{
      console.log(e);
      return e;
    })
  }

}

export default new Vuex.Store({
    state:state,
    mutations:mutations,
    getters:getters,
    actions:actions
});
