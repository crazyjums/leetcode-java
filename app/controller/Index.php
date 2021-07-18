<?php
namespace app\controller;

use app\BaseController;
use think\App;

class Index extends BaseController
{
    public function __construct(App $app)
    {
        parent::__construct($app);
    }

    public function index()
    {
        return '<h1>欢迎小朱同学，这是小朱同学的博客：<a href="https://jums.club" target="_blank">https://jums.club</a></h1>';
    }

    public function hello($name = 'ThinkPHP6')
    {
        return 'this is new. hello,' . $name;
    }

    public function getUser($name = '') {
        return "username: $name";
    }
}
