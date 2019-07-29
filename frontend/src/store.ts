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
  title:"",
  expiration:null
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
      const findIndexNum=state.cards.findIndex(item=>item.id===res.data.id);
      if(findIndexNum===-1){
      state.cards.push(res.data);
      }
      else{
        state.cards[findIndexNum]=res.data;
      }

    }).catch(e=>{
      console.error(e);
    console.log('データ送信時にエラーが発生しました。');
    });
    context.commit('getTodo',state.cards);
  },

  async deleteTodo(context:any,id:Number) {
    await http.delete(`/api/${id}`).then(res => {
      console.log('データを削除します。');
      return res;

    }).catch(e => {
      console.log(e);
      return e;
    })
  },
  async setSearchParams(){
    return;
  }
}

export default new Vuex.Store({
    state,
    mutations,
    getters,
    actions
});
