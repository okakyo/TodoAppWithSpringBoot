<template lang="pug">
    v-card
        v-card-title タスク名
        v-card-text 期限
        v-card-text 作成日
    v-btn
        span 編集
    v-btn
        span 未完了
</template>

<script lang="ts">
    export default {
        name: "todocard"
    }
</script>

<style scoped>

</style>