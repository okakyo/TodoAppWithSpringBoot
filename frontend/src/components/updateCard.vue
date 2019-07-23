<template lang="pug">
    v-card
        v-card-title
            h2 Todoの内容を変更します.
        v-divider
        v-card-text
            v-form(ref="form" lazy-validation)
                v-layout(row,justify-center,full-height,align-center)
                    v-flex(xs2)
                    v-flex(xs6)
                        v-text-field(v-model="title",
                            :counter="30",
                            prepend-icon="assignment"
                            label="タスク",
                            name="title",
                            ref="title",

                            required)
                        v-menu(ref="menu"
                            v-model="menu"
                            :close-on-content-click="false"
                            :nudge-right="40"
                            :return-value.sync="date"
                            lazy
                            transition="scale-transition"
                            offset-y
                            full-width
                            min-width="290px")
                            template(v-slot:activator="{ on }")
                                v-text-field( v-model="date"
                                label="期限"
                                prepend-icon="event"
                                readonly
                                v-on="on")
                            v-date-picker(v-model="date",no-title,scrollable,locale="ja",:day-format="date => new Date(date).getDate()")
                                v-spacer
                                v-btn(flat color="primary" @click="menu = false") Cancel
                                v-btn(flat color="primary" @click="$refs.menu.save(date)") OK
                    v-flex(xs1)
                    v-flex(xs3)
                            v-btn(color="warning" @click="submit")
                                    span 更新

        </template>

<script>
    export default {
        name: "updateCard",
        data(){
                return {
                      card:{},
                      title:"",
                      menu:"",
                      date:"",

                }
        },
        filters: {

            },
        async created(){
                await this.getData();
                this.card=await this.$store.getters.getCard;
                this.title=this.card.title;
                this.date=this.card.expiration;

        },
        computed:{

        },
        methods:{
                async getData(){
                        await this.$store.dispatch('getTodoById',this.$route.params.id)
                },
                async submit(){
                        console.log(this.date);
                        this.card.title=this.title;
                        this.card.expiration=this.date;
                        await this.$store.dispatch('postTodo',this.card).then(()=>{
                                console.log('Update the Card!')
                        }).then(res=>{
                                this.$router.push({ path: "/"})
                        });
                }
        }
    }
</script>

<style scoped>

</style>
