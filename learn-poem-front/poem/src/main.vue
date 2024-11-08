<template>
  <div>
    <h1>诗歌列表</h1>
    <ul>
      <li v-for="poem in poems" :key="poem.id">
        <h2>{{ poem.title }}</h2>
        <p>{{ poem.content }}</p>
        <p>翻译：{{ poem.translation }}</p>
        <p>作者ID：{{ poem.authorId }}</p>
        <p>诗歌类型ID：{{ poem.poemTypeId }}</p>
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      poems: [], // 用于存储从后端获取的诗歌数据
    };
  },
  created() {
    this.fetchPoems();
  },
  methods: {
    fetchPoems() {
      axios.get('http://localhost:8080/learnpoem/poem/selectAll?num=1&size=5', { // 假设后端接口地址为 http://localhost:8080/selectAll
        params: {
          num: 1, // 页码
          size: 10 // 每页大小
        }
      })
        .then(response => {
          this.poems = response.data; // 将后端返回的数据赋值给 poems
        })
        .catch(error => {
          console.error('There was an error!', error);
        });
    }
  }
};
</script>
