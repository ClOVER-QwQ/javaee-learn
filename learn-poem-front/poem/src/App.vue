<template>
  <div id="app">
    <SearchPoemWithPoetByIdBox @search="handleSearch" />
    <SearchResultPage v-if="showResults" :poem="poem" />
    <PoemTable msg="Vite + Vue" />
  </div>
</template>

<script>
import axios from 'axios'; // Import axios
import SearchPoemWithPoetByIdBox from './components/SearchPoemWithPoetByIdBox.vue'; // 引入 SearchPoemWithPoetByIdBox 组件
import SearchResultPage from './components/SearchResultPage.vue'; // 引入 SearchResultPage 组件
import PoemTable from './components/PoemTable.vue'; // 引入 PoemTable 组件

export default {
  name: 'App',
  components: {
    SearchPoemWithPoetByIdBox, // 注册 SearchPoemWithPoetByIdBox 组件
    SearchResultPage, // 注册 SearchResultPage 组件
    PoemTable // 注册 PoemTable 组件
  },
  data() {
    return {
      showResults: false, // 控制是否显示搜索结果页面
      poem: null // 用于存储搜索到的诗文信息
    };
  },
  methods: {
    async handleSearch(searchId) {
      try {
        const response = await axios.get(`http://localhost:8080/learnpoem/poem/selectByIdWithPoet/${searchId}`);
        this.poem = response.data; // 假设返回的数据结构包含 title, content 和 poet 字段
        this.showResults = true; // 显示搜索结果页面
      } catch (error) {
        console.error('Error searching poem:', error);
        alert('搜索失败，请检查ID是否正确');
      }
    }
  }
};
</script>


