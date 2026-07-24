import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: [],
            hasError: false
        };
    }

    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                const postsList = data.map(item => new Post(item.id, item.title, item.body));
                this.setState({ posts: postsList });
            })
            // Setting error bounds or logging if fetch fails
            .catch(error => {
                console.error("Fetch Error:", error);
                this.setState({ hasError: true });
            });
    }

    componentDidMount() {
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        alert("An error happened in the component: " + error.toString());
    }

    render() {
        if (this.state.hasError) {
            return <h2>Something went wrong loading the posts.</h2>;
        }

        return (
            <div>
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ borderBottom: '1px solid #ddd', paddingBottom: '10px', marginBottom: '10px' }}>
                        <h3>{post.title}</h3>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;
