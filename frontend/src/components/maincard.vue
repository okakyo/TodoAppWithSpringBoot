<template lang="pug">
    v-card
        v-card-title
            h2 新しくカードを作成する
        v-divider
        v-card-text
            v-layout(row,justify-center,full-height,align-center)
                v-flex(xs2)
                v-flex(xs6)
                    v-form
                        v-text-field(v-model="title",
                            :rules="nameRules",:counter="30",
                            prepend-icon="assignment"
                            label="タスク",
                            name="title",
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
                    v-btn(color="warning" type="submit")
                        span 提出
</template>

<script>
    export default {
        name: "MainCard",
        data: () => ({
            date: new Date().toISOString().substr(0, 10),

            valid: false,
            name: '',
            nameRules: [
                v => !!v || '何か文字を入力してください',
                v => v.length <= 30 || '30文字以内で記述してください。'
                // エスケープ処理を追加
            ],
        }),

    }
</script>

<style scoped>

</style>