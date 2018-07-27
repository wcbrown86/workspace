//
//  BSTViewController.m
//  Demo3
//
//  Created by William Brown on 12/19/13.
//  Copyright (c) 2013 Brown Sound Technologies. All rights reserved.
//

#import "BSTViewController.h"

@interface BSTViewController ()

@end

@implementation BSTViewController

@synthesize myLabel;

@synthesize myTextField;


- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    
    UIAlertView *myAlert = [[UIAlertView alloc]
                            initWithTitle:@"Wellcome"
                            message: @"Please enter your name"
                            delegate: nil
                            cancelButtonTitle:@"Dissmiss"
                            otherButtonTitles: nil];
    
    [myAlert show];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (IBAction)changeText:(id)sender {
    
    NSString *message = [[NSString alloc] initWithFormat:@"Hello, %@", [myTextField text]];
    [myLabel setText:message];
    [myTextField resignFirstResponder];
    
    
}

- (IBAction)dismissKeyBoard:(id)sender {
    
    [myTextField resignFirstResponder];
}

- (BOOL)textFieldShouldReturn:(UITextField *)textField{
    
    [textField resignFirstResponder];
    return YES;
}
@end
