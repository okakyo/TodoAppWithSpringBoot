<template lang="pug">
    v-card
        v-card-title
            h2 未完了タスクの検索
        v-divider
        v-card-text
            v-layout
                v-flex(xs2)
                v-flex(xs6)
                    v-form
                        v-text-field(label="タスク名" prepend-icon="assignment")
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
</template>

<script>
    export default {
        name: "SearchCard"
    }
</script>

<style scoped>

</style>