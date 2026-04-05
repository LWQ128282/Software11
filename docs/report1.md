# 实验报告 1：环境搭建与 Git 基础操作

## 1. 实验目的
- 安装并配置软件开发环境 (VS Code, Git)。
- 掌握 Git 的基本命令（clone, add, commit, push）。
- 学习使用 Markdown 编写文档。

## 2. 实验环境
- 操作系统：Windows 10/11
- 编辑器：Visual Studio Code
- 版本控制工具：Git

## 3. 实验步骤

### 第一步：软件安装
1. 访问 Visual Studio Code 官网下载并安装了最新版 VS Code。
2. 访问 Git 官网下载并安装了 Git for Windows。
3. 在 VS Code 的扩展商店中，搜索并安装了 "Markdown All in One" 和 "Markdown Preview Enhanced" 插件，以支持 Markdown 文件的预览和编辑。

### 第二步：克隆项目
1. 在 Gitee/GitHub 上复制了作业仓库的 HTTPS 地址。
2. 在本地电脑上新建了文件夹 `Software11`。
3. 在该文件夹内右键打开终端，执行了 `git clone [你的仓库地址]` 命令，成功将远程仓库克隆到本地。

### 第三步：创建作业文件
1. 进入 `Software11` 目录，新建了名为 `docs` 的文件夹。
2. 在 `docs` 文件夹内，新建了文本文档并重命名为 `report1.md`。
3. 使用 VS Code 打开该文件，编写了本份实验报告。

### 第四步：提交代码
1. 在终端中执行 `git add .` 将新文件添加到暂存区。
2. 执行 `git commit -m "完成实验报告1"` 提交更改。
3. 执行 `git push` 将本地提交推送到远程仓库。

## 4. 实验结果
- 成功在本地建立了开发环境。
- 成功通过 Git 管理了项目文件。
- 本文件 `report1.md` 已成功上传至远程仓库。
11