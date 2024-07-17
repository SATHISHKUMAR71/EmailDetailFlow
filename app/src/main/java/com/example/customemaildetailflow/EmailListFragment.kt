package com.example.customemaildetailflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater

class EmailListFragment : Fragment() {

    private val emailList = mutableListOf<Email>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        for(i in 1..5){
            emailList.add(Email("HelloIEEE Conference on Computer Vision and Pattern Recognition is the biggest and one ofIEEE Conference on Computer Vision and Pattern Recognition is the biggest and one ofIEEE Conference on Computer Vision and Pattern Recognition is the biggest and one of","Hi Sathish","12 Seition is tition is tition is tition is tition is tptember","Interested in Java",false,false))
            emailList.add(Email("Googlesion and Pattern Rsion and Pattern R","New Sign in Activity","07 September","Hi Satish is that you signed your google account on the device MK210P",false,false))
            emailList.add(Email("New Email","Heading Line","05 May","This is the sample content",false,false))
            emailList.add(Email("Congratulations","Congratulations Sathishkumar Now you are part of the","05 May","This is the sample content",false,false))
            emailList.add(Email("Learn OpenCv","Hello Visionaries","12 December","Hello Visionaries!,\n" +
                    "\n" +
                    "CVPR - The IEEE Conference on Computer Vision and Pattern Recognition is the biggest and one of the most prestigious conferences in Computer Vision hosting the latest and greatest cutting-edge research in Computer Vision.\n" +
                    "\n" +
                    "About 11,500 research papers were submitted to the conference, out of which, only 2,719 papers were accepted. That number is still too high! How do you keep up with the rate of research?\n" +
                    "\n" +
                    "We have tried to get our heads around the CVPR papers list and found some interesting papers that we feel might be of interest for our users like yourself.",false,false))
            emailList.add(Email("Geeks for Geeks","Become a MongoDB Dev with this","05 May","Looking to unlock the power of MongoDB? This FREE course from GeeksforGeeks is your ultimate guide!\n" +
                    "\n" +
                    "This MongoDB Developer's Toolkit will help you become a CRUD (Create, Read, Update, Delete) operations master and become a confident MongoDB developer.\n" +
                    "\n" +
                    "In this free certificate course, you will learn about:\n" +
                    "\n" +
                    "    Intro to MongoDB\n" +
                    "    Essential MongoDB Concepts\n" +
                    "    MongoDB Transactions\n" +
                    "    Mastering CRUD Operations in MongoDB\n" +
                    "    Advanced MongoDB Aggregation Techniques\n" +
                    "\n" +
                    "and all other concepts that are needed in the real-world. And this free course will also help you earn an official certification from MongoDB. So wait no more and...",false,false))
            emailList.add(Email("Important Announcement", "Action Required: Update Your Password", "10 August", "Dear User,\n\nFor security reasons, we require you to update your password by clicking the following link: [Update Password]\n\nThank you.\n",false,false))
            emailList.add(Email("Special Offer", "Exclusive Discount for Our Loyal Customers", "15 August", "Dear Valued Customer,\n\nWe're excited to offer you an exclusive 30% discount on your next purchase. Use code SPECIAL30 at checkout to redeem.\n\nHappy shopping!\n",false,false))
            emailList.add(Email("Webinar Invitation", "Join Our Webinar on AI in Healthcare", "20 August", "Dear Subscriber,\n\nYou're invited to attend our upcoming webinar on 'The Role of AI in Revolutionizing Healthcare'. Click here to register and secure your spot.\n\nBest regards,\nTeam AI Healthcare\n",false,false))
            // Adding more emails to emailList
            emailList.add(Email("Job OpportunityIEEE Conference on Computer Vision and Pattern Recognition is the biggest and one ofIEEE Conference on Computer Vision and Pattern Recognition is the biggest and one ofIEEE Conference on Computer Vision and Pattern Recognition is the biggest and one of", "ExcitingIEEE Conference on Computer Vision and Pattern Recognition is the biggest and one ofIEEE Conference on Computer Vision and Pattern Recognition is the biggest and one of Software Developer Position", "25 August", "Dear Candidate,\n\nWe are pleased to inform you about an exciting opportunity for a Software Developer role at our company. Please find attached the job description for more details.\n\nBest regards,\nHR Team",false,false))
            emailList.add(Email("New Feature Announcement", "Introducing Dark Mode in Our App", "30 August", "Dear User,\n\nWe're thrilled to announce the rollout of Dark Mode in our mobile app. Enjoy a new visual experience with reduced eye strain during night-time usage.\n\nExplore the app settings to enable Dark Mode today!\n\nRegards,\nApp Development Team",false,false))
            emailList.add(Email("Customer Feedback Survey", "Help Us Serve You Better", "05 September", "Dear Valued Customer,\n\nYour feedback is important to us! Please take a moment to complete our brief survey and share your thoughts about our products and services.\n\nClick here to begin the survey.\n\nThank you for your participation!\nCustomer Experience Team",false,false))
            emailList.add(Email("Event Invitation", "Attend Our Annual Tech Conference", "10 September", "Dear Tech Enthusiast,\n\nYou're invited to our Annual Tech Conference where industry leaders will discuss the latest trends and innovations in technology. Reserve your spot now and stay ahead of the curve!\n\nWarm regards,\nEvent Organizing Committee",false,false))
            emailList.add(Email("Product Launch Announcement", "Introducing Our Latest Smartphone Model", "15 September", "Dear Customer,\n\nWe are excited to announce the launch of our latest smartphone model with advanced features and enhanced performance. Visit our stores or website to learn more.\n\nBest regards,\nMarketing Team",false,false))
            // Adding more emails to emailList
            emailList.add(Email("Holiday Greetings", "Season's Greetings from Our Team", "20 December", "Dear Valued Customer,\n\nWishing you and your loved ones a joyful holiday season filled with peace and happiness. Thank you for your continued support throughout the year.\n\nWarmest regards,\nTeam",false,false))
            emailList.add(Email("Important Update", "Changes to Terms of Service", "01 January", "Dear User,\n\nWe have updated our Terms of Service to better serve you. Please review the changes and accept them to continue using our services.\n\nThank you,\nLegal Team",false,false))
            emailList.add(Email("Reminder", "Upcoming Subscription Renewal", "05 February", "Dear Subscriber,\n\nThis is a reminder that your subscription is set to renew on [Renewal Date]. Ensure your payment details are up-to-date to avoid any interruption in service.\n\nRegards,\nSubscription Team",false,false))
            emailList.add(Email("Community Announcement", "Join Our Local Cleanup Drive", "10 March", "Dear Neighbor,\n\nJoin us in making our community cleaner and greener. Participate in our local cleanup drive scheduled for [Date]. Together, we can make a difference!\n\nBest regards,\nCommunity Council",false,false))
            emailList.add(Email("Workshop Invitation", "Attend Our Photography Workshop", "15 April", "Dear Photography Enthusiast,\n\nJoin us for an interactive workshop where you'll learn professional photography techniques and tips. Limited seats available, register now!\n\nRegards,\nEvent Organizers",false,false))
            emailList.add(Email("New Partnership", "Announcing Our Collaboration with XYZ Company", "20 May", "Dear Stakeholder,\n\nWe are thrilled to announce our strategic partnership with XYZ Company. Together, we look forward to delivering innovative solutions and enhancing customer experiences.\n\nBest regards,\nManagement Team",false,false))
            // Adding more emails to emailList
            emailList.add(Email("Product Update", "Introducing Version 2.0 of Our App", "25 June", "Dear User,\n\nWe are excited to announce the release of Version 2.0 of our app, featuring enhanced performance, new features, and a refreshed user interface. Update now to experience the latest improvements!\n\nBest regards,\nApp Development Team",false,false))
            emailList.add(Email("Customer Appreciation", "Thank You for Your Feedback", "30 July", "Dear Customer,\n\nThank you for sharing your valuable feedback with us. Your input helps us improve our products and services to better meet your needs. We look forward to serving you again!\n\nWarm regards,\nCustomer Support Team",false,false))
            emailList.add(Email("Educational Opportunity", "Enroll in Our Data Science Course", "05 August", "Dear Learner,\n\nDiscover the world of data science with our comprehensive online course. Learn essential skills such as data analysis, machine learning, and data visualization. Enroll today and kickstart your career in data science!\n\nRegards,\nEducation Team",false,false))
            emailList.add(Email("Health Tips", "Stay Healthy with These Simple Tips", "10 September", "Dear Subscriber,\n\nMaintain your well-being with our expert tips on nutrition, exercise, and mental health. Small changes can lead to big improvements in your overall health!\n\nBest wishes,\nHealthcare Experts",false,false))
            emailList.add(Email("Volunteer Opportunity", "Join Us in Supporting Local Shelters", "15 October", "Dear Community Member,\n\nHelp us make a difference in the lives of shelter animals. Volunteer with us and provide care, support, and love to animals in need.\n\nThank you,\nAnimal Welfare Organization",false,false))
            emailList.add(Email("Technology Update", "Explore the Latest Trends in AI", "20 November", "Dear Tech Enthusiast,\n\nStay updated with the latest advancements in artificial intelligence. Discover new research, applications, and innovations shaping the future of AI.\n\nBest regards,\nAI Research Team",false,false))
            // Adding more emails to emailList
            emailList.add(Email("Event Invitation", "Join Us at Our Annual Gala Dinner", "25 December", "Dear Supporter,\n\nYou're invited to join us for an unforgettable evening at our Annual Gala Dinner. Celebrate our achievements and contribute to our mission of [cause]. Reserve your seat today!\n\nWarm regards,\nEvent Committee",false,false))
            emailList.add(Email("Holiday Sale", "Exclusive Discounts on Holiday Gifts", "30 December", "Dear Shopper,\n\nEnjoy special discounts on a wide range of holiday gifts. Shop now and spread joy with thoughtful presents for your loved ones.\n\nHappy holidays!\nMarketing Team",false,false))
            emailList.add(Email("Job Fair Invitation", "Explore Career Opportunities at Our Job Fair", "05 January", "Dear Job Seeker,\n\nDiscover exciting career opportunities at our upcoming job fair. Connect with top employers and explore job openings in various industries.\n\nBest wishes,\nEvent Organizers",false,false))
            emailList.add(Email("Community Update", "Important Neighborhood Watch Meeting", "10 February", "Dear Neighbor,\n\nJoin us for a crucial neighborhood watch meeting to discuss recent safety concerns and collaborate on solutions to ensure our community's well-being.\n\nThank you,\nCommunity Council",false,false))
            emailList.add(Email("Product Launch", "Introducing Our New Fitness Tracker", "15 March", "Dear Fitness Enthusiast,\n\nWe're thrilled to introduce our latest innovation in fitness technology. Track your fitness goals with precision and achieve new milestones.\n\nGet yours today!\nProduct Team",false,false))
            emailList.add(Email("Educational Workshop", "Master Digital Marketing Techniques", "20 April", "Dear Marketer,\n\nEnhance your digital marketing skills with our comprehensive workshop. Learn strategies for effective campaign management and maximize your ROI.\n\nRegister now!\nEducation Team",false,false))
            emailList.add(Email("Charity Event", "Support Our Annual Charity Auction", "25 May", "Dear Supporter,\n\nJoin us in raising funds for [cause] at our annual charity auction. Bid on exclusive items and make a difference in the lives of those in need.\n\nWarm regards,\nCharity Committee",false,false))
            emailList.add(Email("Technology Update", "Explore Quantum Computing Breakthroughs", "30 June", "Dear Tech Enthusiast,\n\nStay ahead of the curve with insights into the latest advancements in quantum computing. Discover how this revolutionary technology is reshaping industries.\n\nBest regards,\nTechnology Innovators",false,false))
            emailList.add(Email("Health Awareness", "Preventive Health Check-Up Reminder", "05 July", "Dear Patient,\n\nIt's time for your annual preventive health check-up. Schedule your appointment today to ensure your well-being and stay proactive about your health.\n\nHealthcare Team",false,false))
            emailList.add(Email("Special Announcement", "Exciting Updates Coming Soon!", "10 August", "Dear Subscriber,\n\nWe have exciting updates in store for you! Stay tuned for announcements about new features, improvements, and more.\n\nRegards,\nProduct Development Team",false,false))
            emailList.add(Email("Educational Webinar", "Unlock Your Potential with Online Learning", "15 September", "Dear Learner,\n\nJoin our upcoming webinar on 'Unlocking Your Potential with Online Learning'. Discover strategies for effective online study habits and career growth.\n\nEducation Team",false,false))
            emailList.add(Email("Event Registration", "Last Chance to Register for Our Conference", "20 October", "Dear Professional,\n\nDon't miss out on your chance to attend our industry-leading conference. Secure your spot today and network with experts in [industry].\n\nEvent Organizers",false,false))
            emailList.add(Email("Community Outreach", "Join Our Beach Cleanup Initiative", "25 November", "Dear Environmental Advocate,\n\nJoin us in preserving our local beaches. Participate in our beach cleanup initiative and make a positive impact on our environment.\n\nThank you,\nCommunity Conservation Team",false,false))
            emailList.add(Email("New Course Launch", "Explore Our Latest Online Course", "30 December", "Dear Learner,\n\nDiscover our newest online course designed to enhance your professional skills. Enroll today and gain expertise in [field].\n\nBest wishes,\nEducation Team",false,false))
            emailList.add(Email("Company Milestone", "Celebrating 10 Years of Innovation", "05 January", "Dear Valued Partner,\n\nWe're excited to celebrate a decade of innovation and growth. Thank you for being part of our journey.\n\nBest regards,\nCompany Leadership",false,false))
            emailList.add(Email("Holiday Schedule", "Office Closure Notice for New Year's Day", "10 February", "Dear Team,\n\nPlease be informed that our office will be closed on New Year's Day. Wishing you a joyful holiday season and a prosperous year ahead.\n\nHR Team",false,false))
            emailList.add(Email("Upcoming Exhibition", "Visit Our Booth at [Event Name]", "15 March", "Dear Visitor,\n\nVisit our booth at [Event Name] to explore our latest products and solutions. We look forward to meeting you!\n\nBest regards,\nMarketing Team",false,false))
            emailList.add(Email("Financial Planning", "Tips for Secure Financial Future", "20 April", "Dear Investor,\n\nSecure your financial future with our expert tips on investment strategies and wealth management.\n\nStart planning today!\nFinance Advisors",false,false))
            emailList.add(Email("Volunteer Appreciation", "Thank You for Your Volunteer Service", "25 May", "Dear Volunteer,\n\nWe deeply appreciate your dedication and commitment to our cause. Your contributions make a significant difference in our community.\n\nWarm regards,\nVolunteer Coordinator",false,false))
            emailList.add(Email("Technology Update", "Introducing Our AI-Powered Assistant", "30 June", "Dear User,\n\nWe're excited to introduce our new AI-powered assistant designed to enhance your productivity and streamline your daily tasks.\n\nDiscover its capabilities today!\nProduct Team",false,false))
            emailList.add(Email("Educational Seminar", "Attend Our Seminar on Emerging Technologies", "05 July", "Dear Tech Enthusiast,\n\nJoin us for an insightful seminar on emerging technologies shaping the future. Gain valuable insights from industry experts.\n\nBest regards,\nEvent Organizers",false,false))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_email_list, container, false)
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        rv.adapter = EmailAdapter(emailList,requireActivity())
        rv.layoutManager =LinearLayoutManager(context)
        rv.addItemDecoration(DividerItemDecoration(rv.context, LinearLayoutManager.VERTICAL))
        return view
    }

}