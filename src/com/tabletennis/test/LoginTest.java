package com.tabletennis.test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class LoginTest extends JFrame {
    private JLabel titleLabel;
    private JLabel loadingLabel;
    private JPanel contentPanel;

    // 计时
    private Timer timeTimer;
    private int second = 0;
    private JLabel timeLabel;

    // 本局比分
    private int scoreLeft = 0;
    private int scoreRight = 0;
    private JLabel scoreLeftLabel;
    private JLabel scoreRightLabel;
    private JLabel ruleTipLabel;
    private JLabel gameRoundLabel;
    private int currentRound = 1;

    // 选手对战配置
    private List<String[]> matchList;
    private int currentMatchIndex = 0;
    private JLabel playerLeftLabel;
    private JLabel playerRightLabel;

    // 赛况表文本组件
    private JLabel groupATable;
    private JLabel groupBTable;

    public LoginTest() {
        initMatchList();

        setTitle("赛事系统引导页");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(90, 170, 240));

        titleLabel = new JLabel("", SwingConstants.CENTER);
        titleLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(50, 30, 300, 30);
        add(titleLabel);

        Timer scrollTimer = new Timer(200, e -> {
            String fullText = "乒乓球女子单打赛事系统";
            int len = titleLabel.getText().length();
            if (len < fullText.length()) {
                titleLabel.setText(fullText.substring(0, len + 1));
            } else {
                titleLabel.setText("");
            }
        });
        scrollTimer.start();

        JButton enterBtn = new JButton("裁判上台，进入赛事系统");
        enterBtn.setBounds(110, 130, 180, 35);
        enterBtn.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        add(enterBtn);

        loadingLabel = new JLabel("正在加载赛事页面...", SwingConstants.CENTER);
        loadingLabel.setBounds(100, 200, 200, 25);
        loadingLabel.setForeground(Color.WHITE);
        loadingLabel.setVisible(false);
        add(loadingLabel);

        enterBtn.addActionListener(e -> {
            loadingLabel.setVisible(true);
            Timer loadTimer = new Timer(1200, event -> {
                loadingLabel.setVisible(false);
                openMainUI();
                LoginTest.this.dispose();
            });
            loadTimer.setRepeats(false);
            loadTimer.start();
        });
    }

    private void initMatchList() {
        matchList = new ArrayList<>();
        // A组
        matchList.add(new String[]{"A1", "A2"});
        matchList.add(new String[]{"A1", "A3"});
        matchList.add(new String[]{"A1", "A4"});
        matchList.add(new String[]{"A1", "A5"});
        matchList.add(new String[]{"A2", "A3"});
        matchList.add(new String[]{"A2", "A4"});
        matchList.add(new String[]{"A2", "A5"});
        matchList.add(new String[]{"A3", "A4"});
        matchList.add(new String[]{"A3", "A5"});
        matchList.add(new String[]{"A4", "A5"});
        // B组
        matchList.add(new String[]{"B1", "B2"});
        matchList.add(new String[]{"B1", "B3"});
        matchList.add(new String[]{"B1", "B4"});
        matchList.add(new String[]{"B1", "B5"});
        matchList.add(new String[]{"B2", "B3"});
        matchList.add(new String[]{"B2", "B4"});
        matchList.add(new String[]{"B2", "B5"});
        matchList.add(new String[]{"B3", "B4"});
        matchList.add(new String[]{"B3", "B5"});
        matchList.add(new String[]{"B4", "B5"});
    }

    private void openMainUI() {
        JFrame mainFrame = new JFrame("乒乓球女子单打赛事管理平台");
        mainFrame.setSize(880, 680);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());

        JPanel navPanel = new JPanel(new GridLayout(1, 8));
        navPanel.setBackground(Color.WHITE);
        JButton btnHome = new JButton("首页");
        JButton btnPlayer = new JButton("参赛名单");
        JButton btnGroup = new JButton("分组赛况表");
        JButton btnSchedule = new JButton("选手日程");
        JButton btnMatch = new JButton("全场赛程");
        JButton btnScore = new JButton("计分计时台");
        JButton btnRank = new JButton("赛事排名");
        JButton btnRule = new JButton("赛制计分规则");

        navPanel.add(btnHome);
        navPanel.add(btnPlayer);
        navPanel.add(btnGroup);
        navPanel.add(btnSchedule);
        navPanel.add(btnMatch);
        navPanel.add(btnScore);
        navPanel.add(btnRank);
        navPanel.add(btnRule);

        contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(showHome(), BorderLayout.CENTER);

        btnHome.addActionListener(e -> switchPanel(showHome()));
        btnPlayer.addActionListener(e -> switchPanel(showPlayerList()));
        btnGroup.addActionListener(e -> switchPanel(showGroupTable()));
        btnSchedule.addActionListener(e -> switchPanel(showPlayerSchedule()));
        btnMatch.addActionListener(e -> switchPanel(showMatchSchedule()));
        btnScore.addActionListener(e -> switchPanel(showScoreBoard()));
        btnRank.addActionListener(e -> switchPanel(showRank()));
        btnRule.addActionListener(e -> switchPanel(showRule()));

        mainFrame.add(navPanel, BorderLayout.NORTH);
        mainFrame.add(contentPanel, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    private void switchPanel(JPanel panel) {
        contentPanel.removeAll();
        contentPanel.add(panel, BorderLayout.CENTER);
        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private JPanel showHome() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("乒乓球女子单打赛事", SwingConstants.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 26));
        panel.add(title);
        panel.add(Box.createVerticalStrut(30));

        panel.add(new JLabel("赛制：分组循环赛 + 单场淘汰赛"));
        panel.add(Box.createVerticalStrut(15));
        panel.add(new JLabel("计分：11分制，10平后需领先2分获胜"));
        panel.add(Box.createVerticalStrut(15));
        panel.add(new JLabel("参赛选手：A1-A5、B1-B5，共10名"));
        panel.add(Box.createVerticalStrut(15));
        panel.add(new JLabel("说明：单场比赛结束后自动切换下一组上场选手，并更新赛况比分"));

        return panel;
    }

    private JPanel showPlayerList() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("参赛选手名单", SwingConstants.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 22));
        panel.add(title);
        panel.add(Box.createVerticalStrut(25));

        panel.add(new JLabel("A组选手：A1、A2、A3、A4、A5"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("B组选手：B1、B2、B3、B4、B5"));
        return panel;
    }

    private JPanel showGroupTable() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("分组循环赛况表", SwingConstants.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 22));
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));

        JLabel groupA = new JLabel("A组对战结果");
        groupA.setFont(new Font("微软雅黑", Font.BOLD, 18));
        panel.add(groupA);
        panel.add(Box.createVerticalStrut(10));

        groupATable = new JLabel(getGroupAHtml());
        panel.add(groupATable);
        panel.add(Box.createVerticalStrut(20));

        JLabel groupB = new JLabel("B组对战结果");
        groupB.setFont(new Font("微软雅黑", Font.BOLD, 18));
        panel.add(groupB);
        panel.add(Box.createVerticalStrut(10));

        groupBTable = new JLabel(getGroupBHtml());
        panel.add(groupBTable);
        return panel;
    }
        private String getGroupAHtml() {
        return "<html>" +
                "A1 vs A2  --:--<br>" +
                "A1 vs A3  --:--<br>" +
                "A1 vs A4  --:--<br>" +
                "A1 vs A5  --:--<br>" +
                "A2 vs A3  --:--<br>" +
                "A2 vs A4  --:--<br>" +
                "A2 vs A5  --:--<br>" +
                "A3 vs A4  --:--<br>" +
                "A3 vs A5  --:--<br>" +
                "A4 vs A5  --:--" +
                "</html>";
    }

    private String getGroupBHtml() {
        return "<html>" +
                "B1 vs B2  --:--<br>" +
                "B1 vs B3  --:--<br>" +
                "B1 vs B4  --:--<br>" +
                "B1 vs B5  --:--<br>" +
                "B2 vs B3  --:--<br>" +
                "B2 vs B4  --:--<br>" +
                "B2 vs B5  --:--<br>" +
                "B3 vs B4  --:--<br>" +
                "B3 vs B5  --:--<br>" +
                "B4 vs B5  --:--" +
                "</html>";
    }

    private void updateGroupTable(String p1, String p2, int s1, int s2) {
        String score = s1 + ":" + s2;
        String newA = groupATable.getText().replace(p1 + " vs " + p2 + "  --:--", p1 + " vs " + p2 + "  " + score);
        newA = newA.replace(p2 + " vs " + p1 + "  --:--", p2 + " vs " + p1 + "  " + score);
        groupATable.setText(newA);

        String newB = groupBTable.getText().replace(p1 + " vs " + p2 + "  --:--", p1 + " vs " + p2 + "  " + score);
        newB = newB.replace(p2 + " vs " + p1 + "  --:--", p2 + " vs " + p1 + "  " + score);
        groupBTable.setText(newB);
    }

    private JPanel showPlayerSchedule() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("选手个人比赛日程表", SwingConstants.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 22));
        panel.add(title);
        panel.add(Box.createVerticalStrut(25));

        panel.add(new JLabel("当前赛事：分组循环赛"));
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("规则：打完一组自动轮换下一组选手上场"));
        panel.add(Box.createVerticalStrut(15));
        if (currentMatchIndex < matchList.size()) {
            String[] curr = matchList.get(currentMatchIndex);
            panel.add(new JLabel("当前上场选手：" + curr[0] + " VS " + curr[1]));
        } else {
            panel.add(new JLabel("所有分组对战已全部结束！"));
        }
        return panel;
    }

    private JPanel showMatchSchedule() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("全场统一赛程", SwingConstants.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 22));
        panel.add(title);
        panel.add(Box.createVerticalStrut(25));
        panel.add(new JLabel("阶段一：A组全员循环对战"));
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel("阶段二：B组全员循环对战"));
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel("阶段三：半决赛、决赛"));
        return panel;
    }

    private JPanel showScoreBoard() {
        JPanel mainPanel = new JPanel(null);
        mainPanel.setBackground(Color.LIGHT_GRAY);

        ruleTipLabel = new JLabel("当前规则：11分制 | 10平后需领先2分获胜");
        ruleTipLabel.setFont(new Font("微软雅黑", Font.BOLD, 14));
        ruleTipLabel.setBounds(220, 10, 380, 25);
        mainPanel.add(ruleTipLabel);

        gameRoundLabel = new JLabel("当前局数：第 " + currentRound + " 局", SwingConstants.CENTER);
        gameRoundLabel.setFont(new Font("微软雅黑", Font.BOLD, 16));
        gameRoundLabel.setBounds(330, 35, 120, 25);
        mainPanel.add(gameRoundLabel);

        JLabel timeTip = new JLabel("比赛计时");
        timeTip.setFont(new Font("微软雅黑", Font.BOLD, 18));
        timeTip.setBounds(330, 65, 120, 30);
        mainPanel.add(timeTip);

        timeLabel = new JLabel("00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("微软雅黑", Font.BOLD, 36));
        timeLabel.setBounds(300, 105, 180, 50);
        mainPanel.add(timeLabel);

        JButton startTimerBtn = new JButton("开始计时");
        startTimerBtn.setBounds(280, 165, 90, 30);
        mainPanel.add(startTimerBtn);

        JButton stopTimerBtn = new JButton("暂停计时");
        stopTimerBtn.setBounds(380, 165, 90, 30);
        mainPanel.add(stopTimerBtn);

        JButton resetTimerBtn = new JButton("重置计时");
        resetTimerBtn.setBounds(330, 205, 90, 30);
        mainPanel.add(resetTimerBtn);

        String[] nowMatch = matchList.get(currentMatchIndex);
        playerLeftLabel = new JLabel(nowMatch[0], SwingConstants.CENTER);
        playerLeftLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        playerLeftLabel.setBounds(120, 270, 120, 30);
        mainPanel.add(playerLeftLabel);

        scoreLeftLabel = new JLabel("0", SwingConstants.CENTER);
        scoreLeftLabel.setFont(new Font("微软雅黑", Font.BOLD, 60));
        scoreLeftLabel.setBounds(120, 310, 120, 80);
        mainPanel.add(scoreLeftLabel);

        JLabel vs = new JLabel("VS", SwingConstants.CENTER);
        vs.setFont(new Font("微软雅黑", Font.BOLD, 24));
        vs.setBounds(370, 340, 80, 40);
        mainPanel.add(vs);

        playerRightLabel = new JLabel(nowMatch[1], SwingConstants.CENTER);
        playerRightLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        playerRightLabel.setBounds(580, 270, 120, 30);
        mainPanel.add(playerRightLabel);

        scoreRightLabel = new JLabel("0", SwingConstants.CENTER);
        scoreRightLabel.setFont(new Font("微软雅黑", Font.BOLD, 60));
        scoreRightLabel.setBounds(580, 310, 120, 80);
        mainPanel.add(scoreRightLabel);

        JButton leftAdd = new JButton("+1");
        leftAdd.setBounds(120, 400, 50, 30);
        mainPanel.add(leftAdd);

        JButton leftSub = new JButton("-1");
        leftSub.setBounds(190, 400, 50, 30);
        mainPanel.add(leftSub);

        JButton rightAdd = new JButton("+1");
        rightAdd.setBounds(580, 400, 50, 30);
        mainPanel.add(rightAdd);

        JButton rightSub = new JButton("-1");
        rightSub.setBounds(650, 400, 50, 30);
        mainPanel.add(rightSub);

        JButton finishMatchBtn = new JButton("本局结束，换下一组选手");
        finishMatchBtn.setBounds(260, 440, 200, 35);
        mainPanel.add(finishMatchBtn);

        timeTimer = new Timer(1000, e -> {
            second++;
            int m = second / 60;
            int s = second % 60;
            timeLabel.setText(String.format("%02d:%02d", m, s));
        });
        startTimerBtn.addActionListener(e -> timeTimer.start());
        stopTimerBtn.addActionListener(e -> timeTimer.stop());
        resetTimerBtn.addActionListener(e -> {
            timeTimer.stop();
            second = 0;
            timeLabel.setText("00:00");
        });

        leftAdd.addActionListener(e -> {
            scoreLeft++;
            checkScoreRule();
        });
        leftSub.addActionListener(e -> {
            if (scoreLeft > 0) {
                scoreLeft--;
                checkScoreRule();
            }
        });
        rightAdd.addActionListener(e -> {
            scoreRight++;
            checkScoreRule();
        });
        rightSub.addActionListener(e -> {
            if (scoreRight > 0) {
                scoreRight--;
                checkScoreRule();
            }
        });

        finishMatchBtn.addActionListener(e -> {
            String pL = playerLeftLabel.getText();
            String pR = playerRightLabel.getText();
            updateGroupTable(pL, pR, scoreLeft, scoreRight);

            currentMatchIndex++;
            if (currentMatchIndex >= matchList.size()) {
                JOptionPane.showMessageDialog(null, "所有分组对战全部完成！");
                resetCurrentRoundData();
                return;
            }

            String[] nextMatch = matchList.get(currentMatchIndex);
            playerLeftLabel.setText(nextMatch[0]);
            playerRightLabel.setText(nextMatch[1]);
            resetCurrentRoundData();
        });

        return mainPanel;
    }

    private void checkScoreRule() {
        scoreLeftLabel.setText(String.valueOf(scoreLeft));
        scoreRightLabel.setText(String.valueOf(scoreRight));

        if (scoreLeft == 5 || scoreRight == 5) {
            ruleTipLabel.setText("提示：一方达到5分，请双方交换场地！");
        } else if (scoreLeft >= 10 && scoreRight >= 10) {
            ruleTipLabel.setText("当前10平！需领先对手2分方可获胜");
        } else if ((scoreLeft >= 11 || scoreRight >= 11) && Math.abs(scoreLeft - scoreRight) >= 2) {
            ruleTipLabel.setText("本局结束！请双方交换场地，准备下一局");
        } else {
            ruleTipLabel.setText("当前规则：11分制 | 10平后需领先2分获胜");
        }
    }

    private void resetCurrentRoundData() {
        scoreLeft = 0;
        scoreRight = 0;
        scoreLeftLabel.setText("0");
        scoreRightLabel.setText("0");
        ruleTipLabel.setText("当前规则：11分制 | 10平后需领先2分获胜");

        currentRound = 1;
        gameRoundLabel.setText("当前局数：第 " + currentRound + " 局");

        timeTimer.stop();
        second = 0;
        timeLabel.setText("00:00");
    }

    private JPanel showRank() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("赛事排名", SwingConstants.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 22));
        panel.add(title);
        panel.add(Box.createVerticalStrut(25));

        panel.add(new JLabel("分组赛结束后可根据赛况表手动更新最终排名"));
        panel.add(Box.createVerticalStrut(12));
        panel.add(new JLabel("A组、B组积分排名以实际对战胜负为准"));
        return panel;
    }

    private JPanel showRule() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JLabel title = new JLabel("乒乓球赛制与计分规则", SwingConstants.CENTER);
        title.setFont(new Font("微软雅黑", Font.BOLD, 24));
        panel.add(title);
        panel.add(Box.createVerticalStrut(25));

        JLabel rule1 = new JLabel("一、基本计分规则");
        rule1.setFont(new Font("微软雅黑", Font.BOLD, 18));
        panel.add(rule1);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("1. 基本计分：采用11分制，一局先拿到11分的一方获胜。"));
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel("2. 平分决胜：比分打到10平后，需领先对手2分才能获胜。"));
        panel.add(Box.createVerticalStrut(15));

        JLabel rule2 = new JLabel("二、局数设置");
        rule2.setFont(new Font("微软雅黑", Font.BOLD, 18));
        panel.add(rule2);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("1. 小组赛、预赛：采用三局两胜制 / 五局三胜制。"));
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel("2. 半决赛、决赛（大型赛事）：采用七局四胜制。"));
        panel.add(Box.createVerticalStrut(15));

        JLabel rule3 = new JLabel("三、场地交换规则");
        rule3.setFont(new Font("微软雅黑", Font.BOLD, 18));
        panel.add(rule3);
        panel.add(Box.createVerticalStrut(10));
        panel.add(new JLabel("1. 每局比赛结束后，双方必须交换场地。"));
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel("2. 决胜局中，任意一方率先拿到5分时，立即交换场地。"));

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginTest().setVisible(true));
    }
}