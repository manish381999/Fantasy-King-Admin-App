package com.tie.adminfantasyking;

public class UploadTeamModel {

    public String match, tournamentName, imTeamA, imTeamB, imTeam, date, time, matchQuality, preview,
            statistics, recommendation, teamA, teamB, aPlaying11, bPlaying11, captain, vCaptain, teamStatus, key;



    public UploadTeamModel(String imTeamA, String imTeamB, String match, String tournamentName, String date, String time, String matchQuality, String preview, String statistics, String teamA, String teamB, String aPlaying11, String bPlaying11, String captain, String vCaptain, String teamStatus, String imTeam, String key) {
        this.match = match;
        this.tournamentName = tournamentName;
        this.imTeamA = imTeamA;
        this.imTeamB = imTeamB;
        this.imTeam = imTeam;
        this.date = date;
        this.time = time;
        this.matchQuality = matchQuality;
        this.preview = preview;
        this.statistics = statistics;
        this.recommendation = recommendation;
        this.teamA = teamA;
        this.teamB = teamB;
        this.aPlaying11 = aPlaying11;
        this.bPlaying11 = bPlaying11;
        this.captain = captain;
        this.vCaptain = vCaptain;
        this.teamStatus = teamStatus;
        this.key = key;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getImTeamA() {
        return imTeamA;
    }

    public void setImTeamA(String imTeamA) {
        this.imTeamA = imTeamA;
    }

    public String getImTeamB() {
        return imTeamB;
    }

    public void setImTeamB(String imTeamB) {
        this.imTeamB = imTeamB;
    }

    public String getImTeam() {
        return imTeam;
    }

    public void setImTeam(String imTeam) {
        this.imTeam = imTeam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMatchQuality() {
        return matchQuality;
    }

    public void setMatchQuality(String matchQuality) {
        this.matchQuality = matchQuality;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getStatistics() {
        return statistics;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getTeamA() {
        return teamA;
    }

    public void setTeamA(String teamA) {
        this.teamA = teamA;
    }

    public String getTeamB() {
        return teamB;
    }

    public void setTeamB(String teamB) {
        this.teamB = teamB;
    }

    public String getaPlaying11() {
        return aPlaying11;
    }

    public void setaPlaying11(String aPlaying11) {
        this.aPlaying11 = aPlaying11;
    }

    public String getbPlaying11() {
        return bPlaying11;
    }

    public void setbPlaying11(String bPlaying11) {
        this.bPlaying11 = bPlaying11;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getvCaptain() {
        return vCaptain;
    }

    public void setvCaptain(String vCaptain) {
        this.vCaptain = vCaptain;
    }

    public String getTeamStatus() {
        return teamStatus;
    }

    public void setTeamStatus(String teamStatus) {
        this.teamStatus = teamStatus;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}