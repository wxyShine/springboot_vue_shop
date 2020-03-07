module.exports = {
  root: true,
  env: {
    node: true
  },
  'extends': [
    'plugin:vue/essential',
    '@vue/standard'
  ],
  rules: {
    'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
    'handle-callback-err': 'off',
    'space-in-parens': 'off',
    "no-irregular-whitespace":"off",//这禁止掉 空格报错检查
    'space-before-function-paren': 0,
    'object-property-newline':"off",
    "indent": ["off", 2]
  },
  parserOptions: {
    parser: 'babel-eslint'
  }
}
