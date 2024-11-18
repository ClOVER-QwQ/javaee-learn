<template>
  <div>
    <h1>搜索结果</h1>
    <div v-if="poem">
      <h2>{{ poem.title }}</h2>
      <p>作者: {{ poem.authorName }}</p>
      <p>类型: {{poem.poemTypeName}}</p>
      <p>{{ poem.content }}</p>
    </div>
    <div v-else>
      <p>没有找到相关诗文。</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SearchResultPage',
  props: {
    poem: Object // 接收父组件传递的诗文数据
  }
};
</script>

<style scoped>
/* 样式可以根据需要进行调整 */
</style>
