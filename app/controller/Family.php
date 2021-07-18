<?php
namespace app\controller;

use app\BaseController;
use app\connector\Index;
use think\App;

class Family extends BaseController
{
    public function __construct(App $app)
    {
        parent::__construct($app);
    }

    public function index() {
        return 'ddd';
    }

    public function getUserInfo($username = '') {
        $index = new \app\controller\Index;
        $res = $index->getUser('内部调用的名字');
        return "username: $username  <br/> $res" ;
    }
}