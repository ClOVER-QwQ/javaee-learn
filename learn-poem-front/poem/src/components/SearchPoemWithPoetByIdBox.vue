<template>
  <div>
    <input v-model="searchId" placeholder="请输入诗文ID进行搜索" />
    <button @click="searchPoem">搜索</button>
  </div>
</template>

<script>
export default {
  name: 'SearchPoemWithPoetByIdBox',
  data() {
    return {
      searchId: ''
    };
  },
  methods: {
    searchPoem() {
      this.$emit('search', this.searchId); // 触发自定义事件，传递搜索ID
    }
  }
};
</script>

<style scoped>
/* 样式可以根据需要进行调整 */
</style>

